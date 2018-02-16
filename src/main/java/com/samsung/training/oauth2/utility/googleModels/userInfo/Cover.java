package com.samsung.training.oauth2.utility.googleModels.userInfo;

public class Cover {

	private CoverInfo coverInfo;

	private CoverPhoto coverPhoto;

	private String layout;

	public CoverInfo getCoverInfo ()
	{
		return coverInfo;
	}

	public void setCoverInfo (CoverInfo coverInfo)
	{
		this.coverInfo = coverInfo;
	}

	public CoverPhoto getCoverPhoto ()
	{
		return coverPhoto;
	}

	public void setCoverPhoto (CoverPhoto coverPhoto)
	{
		this.coverPhoto = coverPhoto;
	}

	public String getLayout ()
	{
		return layout;
	}

	public void setLayout (String layout)
	{
		this.layout = layout;
	}
}
