package bean;

/**
 * Created by srt-k12001 on 2017/12/19.
 */

public class PageBean extends BaseBean {
    private int totalPage ;
    private int pageSize ;
    private int nextPage;
    private int totalCou ;


    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getNextPage() {
        return nextPage;
    }

    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }

    public int getTotalCou() {
        return totalCou;
    }

    public void setTotalCou(int totalCou) {
        this.totalCou = totalCou;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "totalPage=" + totalPage +
                ", pageSize=" + pageSize +
                ", nextPage=" + nextPage +
                ", totalCou=" + totalCou +
                '}';
    }
}
