package learn.paging;

import learn.sort.Sorter;

public class PageRequest implements IPageable{

    private Integer page;
    private Integer maxPageItems;
    private Sorter sorter;

    public PageRequest(Integer page, Integer maxPageItems, Sorter sorter) {
        this.page = page;
        this.maxPageItems = maxPageItems;
        this.sorter = sorter;
    }

    @Override
    public Integer getPage() {
        return this.page;
    }

    @Override
    public Integer getOffset() {
        if (this.page == null || this.maxPageItems == null){
            return null;
        }
        return (this.page - 1) * this.maxPageItems;
    }

    @Override
    public Integer getLimit() {
        return this.maxPageItems;
    }

    @Override
    public Sorter getSorter() {
        return this.sorter;
    }


}
