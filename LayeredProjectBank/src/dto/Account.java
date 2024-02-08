package dto;

public class Account {
    private Integer AccountNo;
    private String userName;
    private Double balance;

    public Account() {
    }

    public Account(Integer accountNo, String userName, Double balance) {
        AccountNo = accountNo;
        this.userName = userName;
        this.balance = balance;

    }

    public Integer getAccountNo() {
        return AccountNo;
    }

    public void setAccountNo(Integer accountNo) {
        AccountNo = accountNo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }


    @Override
    public String toString() {
        return "Bank{" +
                "AccountNo=" + AccountNo +
                ", userName='" + userName + '\'' +
                ", balance=" + balance +
                '}';
    }
}
