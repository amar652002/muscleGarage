package net.gym.muscleGarage.Entity;

import jakarta.persistence.*;

@Entity
@Table(name="equipment")
public class EquipmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String equipmentName;
    private String price;
    private int unit;
    private String purchaseDate;
    private String description;

    public EquipmentEntity() {
    }

    public EquipmentEntity(int id, String equipmentName, String price, int unit, String purchaseDate, String description) {
        this.id = id;
        this.equipmentName = equipmentName;
        this.price = price;
        this.unit = unit;
        this.purchaseDate = purchaseDate;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "EquipmentEntity{" +
                "id=" + id +
                ", equipmentName='" + equipmentName + '\'' +
                ", price='" + price + '\'' +
                ", unit=" + unit +
                ", purchaseDate='" + purchaseDate + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
