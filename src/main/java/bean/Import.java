package bean;

import java.time.LocalDateTime;
import java.util.List;

public class Import {
    private int id;
    private Vendor vendor;
    private List<LineItemImport> listLineItem;
    private LocalDateTime createDate;
    private int status;

    public Import(int id, Vendor vendor, List<LineItemImport> listLineItem, LocalDateTime createDate, int status) {
        this.id = id;
        this.vendor = vendor;
        this.listLineItem = listLineItem;
        this.createDate = createDate;
        this.status = status;
    }

    public Import() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public List<LineItemImport> getListLineItem() {
        return listLineItem;
    }

    public void setListLineItem(List<LineItemImport> listLineItem) {
        this.listLineItem = listLineItem;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
