package org.zt.ssmm.core;

public class Userdata {
	 private Integer id;

	    private String sTitle;
	    private String title;
	    private String career;
	    private String abme;
	    private String mywk;
	    
	    public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getCareer() {
			return career;
		}

		public void setCareer(String career) {
			this.career = career;
		}

		public String getAbme() {
			return abme;
		}

		public void setAbme(String abme) {
			this.abme = abme;
		}

		public String getMywk() {
			return mywk;
		}

		public void setMywk(String mywk) {
			this.mywk = mywk;
		}

		private Integer userId;

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getsTitle() {
			return sTitle;
		}

		public void setsTitle(String sTitle) {
			this.sTitle = sTitle;
		}

		public Integer getUserId() {
			return userId;
		}

		public void setUserId(Integer userId) {
			this.userId = userId;
		}

}
