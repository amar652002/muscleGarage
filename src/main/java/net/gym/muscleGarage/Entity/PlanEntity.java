package net.gym.muscleGarage.Entity;

import jakarta.persistence.*;

@Entity
@Table(name="plan")
public class PlanEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String planName;
    private int amount;
    private String duration;

    public PlanEntity() {
    }

    public PlanEntity(int id, String planName, int amount, String duration) {
        this.id = id;
        this.planName = planName;
        this.amount = amount;
        this.duration = duration;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "PlanEntity{" +
                "id=" + id +
                ", planName='" + planName + '\'' +
                ", amount=" + amount +
                ", duration='" + duration + '\'' +
                '}';
    }
}
