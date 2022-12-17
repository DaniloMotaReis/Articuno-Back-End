package br.com.articuno.model;

import java.util.Random;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idUser;
	private String email;
	private String password;
	private String nickname;
	private String picture = image();
	private String status;
	
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public User() {
		
	}
	public User(int idUser, String email, String password, String nickname, String status) {
		super();
		this.idUser = idUser;
		this.email = email;
		this.password = password;
		this.nickname = nickname;
		this.status = status;
	}
	private String image() {
		String imagens[] = {"https://i.pinimg.com/474x/d5/c8/eb/d5c8ebdfa1eb3ec56d3c284577f3a1c6.jpg", "https://i.pinimg.com/736x/aa/e7/d4/aae7d46d8f0f6b108b720b404ebbbf52.jpg", "https://i.pinimg.com/236x/37/01/e7/3701e763f6ded4234b68d8fac1a9fa85.jpg", "https://i.pinimg.com/236x/a6/f2/53/a6f25369334938bc1a3efe14f1f3d229.jpg", "https://i0.wp.com/techwek.com/wp-content/uploads/2020/12/bem-aleatorio..jpg", "https://i.pinimg.com/474x/dd/31/32/dd3132e6ade567c8d32df5de3b8ff585.jpg", "https://i.pinimg.com/564x/ac/86/f3/ac86f34bbc9d9f36b91c3b62e992eb5b.jpg", "https://i.pinimg.com/564x/07/5b/da/075bda0b51f3eeea50cd056bbd07a1e6.jpg", "https://img.wattpad.com/cover/241540477-288-k502307.jpg", "https://pbs.twimg.com/profile_images/1310672067965181952/YCTa_Ri5_400x400.jpg"};
		Random random = new Random();
		int numIma = random.nextInt(0, imagens.length);
		return imagens[numIma];
	}
}
