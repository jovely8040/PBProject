package vo;

public class PhonebookVO {

	// 필드 작성
	private Long id;
	private String name;
	private String hp;
	private String tel;

	public PhonebookVO() {
	}

	public PhonebookVO(String name, String hp, String tel) {
		this.name = name;
		this.hp = hp;
		this.tel = tel;

	}

	public PhonebookVO(long id, String name, String hp, String tel) {
		this.id = id;
		this.name = name;
		this.hp = hp;
		this.tel = tel;
	}

	public Long getId() {
		return id == null ? 0 : id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name == null ? "" : name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHp() {
		return hp == null ? "" : hp;
	}

	public void setHp(String hp) {
		this.hp = hp;
	}

	public String getTel() {
		return tel == null ? "" : tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Override
	public String toString() {
		return "hpVO [id=" + id + ", name=" + name + ", hp=" + hp + ", tel=" + tel + "]";
	}

}