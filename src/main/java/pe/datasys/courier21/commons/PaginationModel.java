package pe.datasys.courier21.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaginationModel {
    private Integer pageNumber = 0;
    private Integer rowsPerPage = 0;
    private String username;
    // private Long totalPges;

    private List<Filter> filters = new ArrayList<>();
    private List<SortModel> sorts;

    public PaginationModel(Integer pageNumber, Integer rowsPerPage) {
        this.pageNumber = pageNumber;
        this.rowsPerPage = rowsPerPage;
    }

    public PaginationModel(Integer pageNumber, Integer rowsPerPage, List<Filter> filters ) {
        this.pageNumber = pageNumber;
        this.rowsPerPage = rowsPerPage;
        this.filters = filters;
    }

    public PaginationModel(Integer pageNumber, Integer rowsPerPage, List<Filter> filters, String username ) {
        this.pageNumber = pageNumber;
        this.rowsPerPage = rowsPerPage;
        this.filters = filters;
        this.username = username;
    }

    public PaginationModel(Integer pageNumber, Integer rowsPerPage, Long totalRows) {
        this.pageNumber = pageNumber;
        this.rowsPerPage = rowsPerPage;
    }
}
