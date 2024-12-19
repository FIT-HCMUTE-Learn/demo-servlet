package learn.paging;

import learn.sort.Sorter;

public interface IPageable {
    Integer getPage();
    Integer getOffset();
    Integer getLimit();
    Sorter getSorter();
}
