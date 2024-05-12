package org.example.wschat.dto;

public class Auction {

    private int id;

    private String name;
    private String bidder;
    private Long minPrice;

    private Long expirationTime;
    //getters and setters


    public Auction(int id, String name, String bidder, Long minPrice, Long expirationTime) {
        this.id = id;
        this.name = name;
        this.bidder = bidder;
        this.minPrice = minPrice;
        this.expirationTime = expirationTime;
    }

    public String getName() {
        return name;
    }

    public String getBidder() {
        return bidder;
    }

    public Long getMinPrice() {
        return minPrice;
    }

    public Long getExpirationTime() {
        return expirationTime;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBidder(String bidder) {
        this.bidder = bidder;
    }

    public void setMinPrice(Long minPrice) {
        this.minPrice = minPrice;
    }

    public void setExpirationTime(Long expirationTime) {
        this.expirationTime = expirationTime;
    }

    @Override
    public String toString() {
        return "Auction{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", bidder='" + bidder + '\'' +
                ", minPrice=" + minPrice +
                ", expirationTime=" + expirationTime +
                '}';
    }
}
