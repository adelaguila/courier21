package pe.datasys.courier21.util;

import jakarta.persistence.Query;
import pe.datasys.courier21.commons.Filter;
import pe.datasys.courier21.commons.SortModel;

import java.util.List;

public class PaginateUtil {
    public String getFiltersColumns(String column, String operator, String parametro) {
        String sql = "";
        if (operator.equals("=")) {
            sql = " AND ".concat(column).concat(" = ").concat(parametro);
        }
        if (operator.equals(">")) {
            sql = " AND ".concat(column).concat(" > ").concat(parametro);
        }
        if (operator.equals(">=")) {
            sql = " AND ".concat(column).concat(" >= ").concat(parametro);
        }
        if (operator.equals("<")) {
            sql = " AND ".concat(column).concat(" < ").concat(parametro);
        }
        if (operator.equals("<")) {
            sql = " AND ".concat(column).concat(" <= ").concat(parametro);
        }
        if (operator.equals("LIKE")) {
            sql = " AND ".concat(column).concat(" LIKE concat(").concat("'%', ").concat(parametro).concat(", '%')");
        }
        return sql;
    }

    public StringBuilder getFilters(List<Filter> filters, List<String> cols) {

        StringBuilder sql = new StringBuilder("where 1=1 ");
        for (Filter filtro : filters) {
            String txtFiltro = "";
            for (String elemento : cols) {
                if (elemento.contains(filtro.getField())) {
                    txtFiltro = elemento;
                    break;
                }
            }

            int col = cols.indexOf(txtFiltro);

            if (txtFiltro.equals(cols.get(col))) {
                sql.append(getFiltersColumns("a." + txtFiltro, filtro.getMatchMode(), ":" + filtro.getField()));
            }
        }
        return sql;
    }

    public Query setParams(List<Filter> filters, Query query, List<String> cols) {
        String txtFiltro = "";
        for (Filter filtro : filters) {
            for (String elemento : cols) {
                if (elemento.contains(filtro.getField())) {
                    txtFiltro = elemento;
                    break;
                }
            }

            int col = cols.indexOf(txtFiltro);

            if (txtFiltro.equals(cols.get(col))) {
                query.setParameter(filtro.getField(), filtro.getValue());
            }
        }
        return query;
    }

    public StringBuilder getOrder(List<SortModel> sorts, List<String> cols) {

        String preSql = "";
        String txtFiltro = "";
        for (SortModel sort : sorts) {
            for (String elemento : cols) {
                if (elemento.contains(sort.getField())) {
                    txtFiltro = elemento;
                    break;
                }
            }

            int col = cols.indexOf(txtFiltro);

            if (txtFiltro.equals(cols.get(col))) {
                preSql = " ORDER BY a." + txtFiltro + " " + sort.getSort();
            }
        }

        StringBuilder sql = new StringBuilder(preSql);

        return sql;
    }
}
