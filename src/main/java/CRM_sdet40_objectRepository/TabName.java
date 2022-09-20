package CRM_sdet40_objectRepository;

public enum TabName {
	Contacts("Contacts"), oppoertunities("oppoertunities"), Organisation("Organisation"), Email("Email"), Campaign(" Campaign"),
	Dashboard("Dashboard"), Signout("Sign out");
	
	private String tabName;
	private TabName(String tabName) {
		this.tabName=tabName;
		
	}
	public String getTabName() {
		return tabName;
	}
	

}
