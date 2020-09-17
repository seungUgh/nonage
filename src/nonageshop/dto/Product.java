package nonageshop.dto;

import java.util.Date;

public class Product {
	private int no; //상품번호
	private String name; //상품명
	private String kind; //상품 종류
	private int price; //원가
	private int salePrice; //판매가
	private int margin; //수익
	private String content; //상품내용
	private String img; //상품 이미지
	private String delYn; //상품 삭제여부 'y' - 사용, 'n' - 삭제
	private String bestYn; //베스트 상품 여부 
	private Date regDate;  //등록일
	
	
	public Product() {
	}


	public Product(int no, String name, int salePrice, String img) {
		this.no = no;
		this.name = name;
		this.salePrice = salePrice;
		this.img = img;
	}

	
	
	public Product(int no, String name, String kind, int price, int salePrice, int margin, String content,
			String img, String delYn, String bestYn, Date regDate) {
		this.no = no;
		this.name = name;
		this.kind = kind;
		this.price = price;
		this.salePrice = salePrice;
		this.margin = margin;
		this.content = content;
		this.img = img;
		this.delYn = delYn;
		this.bestYn = bestYn;
		this.regDate = regDate;
	}


	public int getNo() {
		return no;
	}


	public void setNo(int no) {
		this.no = no;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getKind() {
		return kind;
	}


	public void setKind(String kind) {
		this.kind = kind;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public int getSalePrice() {
		return salePrice;
	}


	public void setSalePrice(int salePrice) {
		this.salePrice = salePrice;
	}


	public int getMargin() {
		return margin;
	}


	public void setMargin(int margin) {
		this.margin = margin;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getImg() {
		return img;
	}


	public void setImg(String img) {
		this.img = img;
	}


	public String getDelYn() {
		return delYn;
	}


	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}


	public String getBestYn() {
		return bestYn;
	}


	public void setBestYn(String bestYn) {
		this.bestYn = bestYn;
	}


	public Date getRegDate() {
		return regDate;
	}


	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}


	@Override
	public String toString() {
		return String.format(
				"Product [no=%s, name=%s, kind=%s, price=%s, salePrice=%s, margin=%s, content=%s, img=%s, delYn=%s, bestYn=%s, regDate=%s]",
				no, name, kind, price, salePrice, margin, content, img, delYn, bestYn, regDate);
	}
	
	
}
