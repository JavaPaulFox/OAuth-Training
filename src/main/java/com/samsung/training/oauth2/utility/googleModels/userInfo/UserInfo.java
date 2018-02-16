package com.samsung.training.oauth2.utility.googleModels.userInfo;

public class UserInfo {

	private String etag;

	private Image image;

	private String isPlusUser;

	private Emails[] emails;

	private String kind;

	private String url;

	private String id;

	private Cover cover;

	private String verified;

	private Name name;

	private String circledByCount;

	private String gender;

	private PlacesLived[] placesLived;

	private String language;

	private String displayName;

	private String objectType;

	public String getEtag ()
	{
		return etag;
	}

	public void setEtag (String etag)
	{
		this.etag = etag;
	}

	public Image getImage ()
	{
		return image;
	}

	public void setImage (Image image)
	{
		this.image = image;
	}

	public String getIsPlusUser ()
	{
		return isPlusUser;
	}

	public void setIsPlusUser (String isPlusUser)
	{
		this.isPlusUser = isPlusUser;
	}

	public Emails[] getEmails ()
	{
		return emails;
	}

	public void setEmails (Emails[] emails)
	{
		this.emails = emails;
	}

	public String getKind ()
	{
		return kind;
	}

	public void setKind (String kind)
	{
		this.kind = kind;
	}

	public String getUrl ()
	{
		return url;
	}

	public void setUrl (String url)
	{
		this.url = url;
	}

	public String getId ()
	{
		return id;
	}

	public void setId (String id)
	{
		this.id = id;
	}

	public Cover getCover ()
	{
		return cover;
	}

	public void setCover (Cover cover)
	{
		this.cover = cover;
	}

	public String getVerified ()
	{
		return verified;
	}

	public void setVerified (String verified)
	{
		this.verified = verified;
	}

	public Name getName ()
	{
		return name;
	}

	public void setName (Name name)
	{
		this.name = name;
	}

	public String getCircledByCount ()
	{
		return circledByCount;
	}

	public void setCircledByCount (String circledByCount)
	{
		this.circledByCount = circledByCount;
	}

	public String getGender ()
	{
		return gender;
	}

	public void setGender (String gender)
	{
		this.gender = gender;
	}

	public PlacesLived[] getPlacesLived ()
	{
		return placesLived;
	}

	public void setPlacesLived (PlacesLived[] placesLived)
	{
		this.placesLived = placesLived;
	}

	public String getLanguage ()
	{
		return language;
	}

	public void setLanguage (String language)
	{
		this.language = language;
	}

	public String getDisplayName ()
	{
		return displayName;
	}

	public void setDisplayName (String displayName)
	{
		this.displayName = displayName;
	}

	public String getObjectType ()
	{
		return objectType;
	}

	public void setObjectType (String objectType)
	{
		this.objectType = objectType;
	}
}
