package pl.ksiegarnia.rest.model;

import java.util.List;

/**
 * Created by pgrubarek on 17.08.15.
 */
public class Item {
    private static final long serialVersionUID = 4764932857557385437L;

    private Long id;
    private Double price;
    private Integer quantity;

    public List<Long> itemList;

    public Item() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public List<Long> getItemList() {
        return itemList;
    }

    public void setItemList(List<Long> itemList) {
        this.itemList = itemList;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", price=" + price +
                ", quantity=" + quantity +
                ", itemList=" + itemList +
                '}';
    }
}
