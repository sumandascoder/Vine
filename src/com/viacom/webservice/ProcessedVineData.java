package com.viacom.webservice;

import java.util.List;

public class ProcessedVineData {

	private String code;
	private data dataVar;
	
	private boolean success;
	private String error;
	
	
	private class data{
		
		private int count;
		private String anchorStr;
		private List<records> recordsVar;
		
		private String previousPage;
		private String backAnchor;
		private String anchor;
		private int nextPage;
		private int size;
		
		private class records{
			private int liked;
			private String videoDashUrl;
			private String foursquareVenueId;
			private String userId;
			private int privatePeople;
			private List<likes> likesList;
			
			private class likes{
				private int count;
				private String anchorStr;
				private List<recordIn> recordList;
				
				private class recordIn{
					private String username;
					private int verified;
					private List<vanityUrls> urls;
					private class vanityUrls{
						private List<String> values;
					}
					private String created;
					private String userId;
					private user userVal;
					
					private class user{
						private int privateVal;
					}
					
					private String likeId;

					public String getUsername() {
						return username;
					}

					public void setUsername(String username) {
						this.username = username;
					}

					public int getVerified() {
						return verified;
					}

					public void setVerified(int verified) {
						this.verified = verified;
					}

					public List<vanityUrls> getUrls() {
						return urls;
					}

					public void setUrls(List<vanityUrls> urls) {
						this.urls = urls;
					}

					public String getCreated() {
						return created;
					}

					public void setCreated(String created) {
						this.created = created;
					}

					public String getUserId() {
						return userId;
					}

					public void setUserId(String userId) {
						this.userId = userId;
					}

					public user getUserVal() {
						return userVal;
					}

					public void setUserVal(user userVal) {
						this.userVal = userVal;
					}

					public String getLikeId() {
						return likeId;
					}

					public void setLikeId(String likeId) {
						this.likeId = likeId;
					}
					
				}
				
				private String previousPage;
				private String backAnchor;
				private String anchor;
				private int nextPage;
				private int size;
				public int getCount() {
					return count;
				}
				public void setCount(int count) {
					this.count = count;
				}
				public String getAnchorStr() {
					return anchorStr;
				}
				public void setAnchorStr(String anchorStr) {
					this.anchorStr = anchorStr;
				}
				public List<recordIn> getRecordList() {
					return recordList;
				}
				public void setRecordList(List<recordIn> recordList) {
					this.recordList = recordList;
				}
				public String getPreviousPage() {
					return previousPage;
				}
				public void setPreviousPage(String previousPage) {
					this.previousPage = previousPage;
				}
				public String getBackAnchor() {
					return backAnchor;
				}
				public void setBackAnchor(String backAnchor) {
					this.backAnchor = backAnchor;
				}
				public String getAnchor() {
					return anchor;
				}
				public void setAnchor(String anchor) {
					this.anchor = anchor;
				}
				public int getNextPage() {
					return nextPage;
				}
				public void setNextPage(int nextPage) {
					this.nextPage = nextPage;
				}
				public int getSize() {
					return size;
				}
				public void setSize(int size) {
					this.size = size;
				}
				
			}
			private loops loop;
			
			private class loops{
				private int count;
				private double velocity;
				private int onFire;
				public int getCount() {
					return count;
				}
				public void setCount(int count) {
					this.count = count;
				}
				public double getVelocity() {
					return velocity;
				}
				public void setVelocity(double velocity) {
					this.velocity = velocity;
				}
				public int getOnFire() {
					return onFire;
				}
				public void setOnFire(int onFire) {
					this.onFire = onFire;
				}
			}
			private String thumbnailUrl;
	        private int explicitContent;
	        private int myRepostId;
	        private String description;
	        private int verified;
	        private String avatarUrl;
			private comments comment;
			private class comments{
				private int count;
				private String anchorStr;
				private List<recordsInn> records;
				private class recordsInn{
					
				}
				private String previousPage;
				private String backAnchor;
				private String anchor;
				private int nextPage;
				private int size;
				public int getCount() {
					return count;
				}
				public void setCount(int count) {
					this.count = count;
				}
				public String getAnchorStr() {
					return anchorStr;
				}
				public void setAnchorStr(String anchorStr) {
					this.anchorStr = anchorStr;
				}
				public List<recordsInn> getRecords() {
					return records;
				}
				public void setRecords(List<recordsInn> records) {
					this.records = records;
				}
				public String getPreviousPage() {
					return previousPage;
				}
				public void setPreviousPage(String previousPage) {
					this.previousPage = previousPage;
				}
				public String getBackAnchor() {
					return backAnchor;
				}
				public void setBackAnchor(String backAnchor) {
					this.backAnchor = backAnchor;
				}
				public String getAnchor() {
					return anchor;
				}
				public void setAnchor(String anchor) {
					this.anchor = anchor;
				}
				public int getNextPage() {
					return nextPage;
				}
				public void setNextPage(int nextPage) {
					this.nextPage = nextPage;
				}
				public int getSize() {
					return size;
				}
				public void setSize(int size) {
					this.size = size;
				}
			}
			
			
			private List<entities> entities;
			
			private class entities{
				private List<vanityUrls> urls;
				private class vanityUrls{
					private List<String> values;
				}
				private String title;
				private List<range> ranges;
				private class range{
					private List<Integer> values;
				}
				private String link;
				private String type;
				private String id;
				public List<vanityUrls> getUrls() {
					return urls;
				}
				public void setUrls(List<vanityUrls> urls) {
					this.urls = urls;
				}
				public String getTitle() {
					return title;
				}
				public void setTitle(String title) {
					this.title = title;
				}
				public List<range> getRanges() {
					return ranges;
				}
				public void setRanges(List<range> ranges) {
					this.ranges = ranges;
				}
				public String getLink() {
					return link;
				}
				public void setLink(String link) {
					this.link = link;
				}
				public String getType() {
					return type;
				}
				public void setType(String type) {
					this.type = type;
				}
				public String getId() {
					return id;
				}
				public void setId(String id) {
					this.id = id;
				}
			}
			private String videoLowURL;
			private int blocked;
			private String username;
			private String videoWebmUrl;
			private List<vanityUrls> urls;
			private class vanityUrls{
				private List<String> values;
			}
			private List<tags> tags;
			private class tags{
				private List<String> values;
			}
			private String permalinkUrl;
			private int following;
			private String postId;
			private String videoUrl;
			private int followRequested;
			private String created;
			private String shareUrl;
			private String profileBackground;
			private int promoted;
			private List<reposts> reposts;
			private class reposts{
				private int count;
				private String anchorStr;
				private List<recordsInn> records;
				private class recordsInn{
					
				}
				private String previousPage;
				private String backAnchor;
				private String anchor;
				private int nextPage;
				private int size;
				public int getCount() {
					return count;
				}
				public void setCount(int count) {
					this.count = count;
				}
				public String getAnchorStr() {
					return anchorStr;
				}
				public void setAnchorStr(String anchorStr) {
					this.anchorStr = anchorStr;
				}
				public List<recordsInn> getRecords() {
					return records;
				}
				public void setRecords(List<recordsInn> records) {
					this.records = records;
				}
				public String getPreviousPage() {
					return previousPage;
				}
				public void setPreviousPage(String previousPage) {
					this.previousPage = previousPage;
				}
				public String getBackAnchor() {
					return backAnchor;
				}
				public void setBackAnchor(String backAnchor) {
					this.backAnchor = backAnchor;
				}
				public String getAnchor() {
					return anchor;
				}
				public void setAnchor(String anchor) {
					this.anchor = anchor;
				}
				public int getNextPage() {
					return nextPage;
				}
				public void setNextPage(int nextPage) {
					this.nextPage = nextPage;
				}
				public int getSize() {
					return size;
				}
				public void setSize(int size) {
					this.size = size;
				}
			}
			public int getLiked() {
				return liked;
			}
			public void setLiked(int liked) {
				this.liked = liked;
			}
			public String getVideoDashUrl() {
				return videoDashUrl;
			}
			public void setVideoDashUrl(String videoDashUrl) {
				this.videoDashUrl = videoDashUrl;
			}
			public String getFoursquareVenueId() {
				return foursquareVenueId;
			}
			public void setFoursquareVenueId(String foursquareVenueId) {
				this.foursquareVenueId = foursquareVenueId;
			}
			public String getUserId() {
				return userId;
			}
			public void setUserId(String userId) {
				this.userId = userId;
			}
			public int getPrivatePeople() {
				return privatePeople;
			}
			public void setPrivatePeople(int privatePeople) {
				this.privatePeople = privatePeople;
			}
			public List<likes> getLikesList() {
				return likesList;
			}
			public void setLikesList(List<likes> likesList) {
				this.likesList = likesList;
			}
			public loops getLoop() {
				return loop;
			}
			public void setLoop(loops loop) {
				this.loop = loop;
			}
			public String getThumbnailUrl() {
				return thumbnailUrl;
			}
			public void setThumbnailUrl(String thumbnailUrl) {
				this.thumbnailUrl = thumbnailUrl;
			}
			public int getExplicitContent() {
				return explicitContent;
			}
			public void setExplicitContent(int explicitContent) {
				this.explicitContent = explicitContent;
			}
			public int getMyRepostId() {
				return myRepostId;
			}
			public void setMyRepostId(int myRepostId) {
				this.myRepostId = myRepostId;
			}
			public String getDescription() {
				return description;
			}
			public void setDescription(String description) {
				this.description = description;
			}
			public int getVerified() {
				return verified;
			}
			public void setVerified(int verified) {
				this.verified = verified;
			}
			public String getAvatarUrl() {
				return avatarUrl;
			}
			public void setAvatarUrl(String avatarUrl) {
				this.avatarUrl = avatarUrl;
			}
			public comments getComment() {
				return comment;
			}
			public void setComment(comments comment) {
				this.comment = comment;
			}
			public List<entities> getEntities() {
				return entities;
			}
			public void setEntities(List<entities> entities) {
				this.entities = entities;
			}
			public String getVideoLowURL() {
				return videoLowURL;
			}
			public void setVideoLowURL(String videoLowURL) {
				this.videoLowURL = videoLowURL;
			}
			public int getBlocked() {
				return blocked;
			}
			public void setBlocked(int blocked) {
				this.blocked = blocked;
			}
			public String getUsername() {
				return username;
			}
			public void setUsername(String username) {
				this.username = username;
			}
			public String getVideoWebmUrl() {
				return videoWebmUrl;
			}
			public void setVideoWebmUrl(String videoWebmUrl) {
				this.videoWebmUrl = videoWebmUrl;
			}
			public List<vanityUrls> getUrls() {
				return urls;
			}
			public void setUrls(List<vanityUrls> urls) {
				this.urls = urls;
			}
			public List<tags> getTags() {
				return tags;
			}
			public void setTags(List<tags> tags) {
				this.tags = tags;
			}
			public String getPermalinkUrl() {
				return permalinkUrl;
			}
			public void setPermalinkUrl(String permalinkUrl) {
				this.permalinkUrl = permalinkUrl;
			}
			public int getFollowing() {
				return following;
			}
			public void setFollowing(int following) {
				this.following = following;
			}
			public String getPostId() {
				return postId;
			}
			public void setPostId(String postId) {
				this.postId = postId;
			}
			public String getVideoUrl() {
				return videoUrl;
			}
			public void setVideoUrl(String videoUrl) {
				this.videoUrl = videoUrl;
			}
			public int getFollowRequested() {
				return followRequested;
			}
			public void setFollowRequested(int followRequested) {
				this.followRequested = followRequested;
			}
			public String getCreated() {
				return created;
			}
			public void setCreated(String created) {
				this.created = created;
			}
			public String getShareUrl() {
				return shareUrl;
			}
			public void setShareUrl(String shareUrl) {
				this.shareUrl = shareUrl;
			}
			public String getProfileBackground() {
				return profileBackground;
			}
			public void setProfileBackground(String profileBackground) {
				this.profileBackground = profileBackground;
			}
			public int getPromoted() {
				return promoted;
			}
			public void setPromoted(int promoted) {
				this.promoted = promoted;
			}
			public List<reposts> getReposts() {
				return reposts;
			}
			public void setReposts(List<reposts> reposts) {
				this.reposts = reposts;
			}
	}
	/**
	 * {
  "code": "",
  "data": {
    "count": 338,
    "anchorStr": "1157495138264801280",
    "records": [
      {
        "liked": 0,
        "videoDashUrl": "http:\/\/v.cdn.vine.co\/r\/videos_h264dash\/556708D6651172332562849406976_31ec24cd3c6.1.5.8550682683537126991.mp4?versionId=nxPlUXgXunrbvhW2vZRrQCVB4Z1ppKAX",
        "foursquareVenueId": null,
        "userId": 9.1875319047062e+17,
        "private": 0,
        "likes": {
          "count": 21456,
          "anchorStr": "1174504170523701248",
          "records": [
            {
              "username": "juliean mcdaniel",
              "verified": 0,
              "vanityUrls": [
                
              ],
              "created": "2015-02-03T21:10:29.000000",
              "userId": 9.9826135823797e+17,
              "user": {
                "private": 1
              },
              "likeId": 1.1745041705237e+18
            },
            {
              "username": "Oliversachi",
              "verified": 0,
              "vanityUrls": [
                
              ],
              "created": "2015-02-03T21:10:58.000000",
              "userId": 9.3299794156678e+17,
              "user": {
                "private": 0
              },
              "likeId": 1.1745042926867e+18
            },
            {
              "username": "Logan Crawford",
              "verified": 0,
              "vanityUrls": [
                
              ],
              "created": "2015-02-03T21:12:13.000000",
              "userId": 1.1251991902937e+18,
              "user": {
                "private": 0
              },
              "likeId": 1.174504607897e+18
            },
            {
              "username": "Hayley McDivitt",
              "verified": 0,
              "vanityUrls": [
                
              ],
              "created": "2015-02-03T21:13:55.000000",
              "userId": 9.4011517454583e+17,
              "user": {
                "private": 0
              },
              "likeId": 1.1745050328096e+18
            },
            {
              "username": "Cherra Atkinson",
              "verified": 0,
              "vanityUrls": [
                
              ],
              "created": "2015-02-03T21:14:03.000000",
              "userId": 9.377881144103e+17,
              "user": {
                "private": 1
              },
              "likeId": 1.174505068478e+18
            },
            {
              "username": "Kat Sloan",
              "verified": 0,
              "vanityUrls": [
                
              ],
              "created": "2015-02-03T21:15:04.000000",
              "userId": 1.0505920989883e+18,
              "user": {
                "private": 0
              },
              "likeId": 1.17450532251e+18
            },
            {
              "username": "Nicole Sanchez",
              "verified": 0,
              "vanityUrls": [
                
              ],
              "created": "2015-02-03T21:15:30.000000",
              "userId": 9.9845554853195e+17,
              "user": {
                "private": 0
              },
              "likeId": 1.174505433135e+18
            },
            {
              "username": "Charity Stow",
              "verified": 0,
              "vanityUrls": [
                
              ],
              "created": "2015-02-03T21:16:39.000000",
              "userId": 9.733492468018e+17,
              "user": {
                "private": 0
              },
              "likeId": 1.1745057209856e+18
            },
            {
              "username": "Melissa Fulham",
              "verified": 0,
              "vanityUrls": [
                
              ],
              "created": "2015-02-03T21:16:49.000000",
              "userId": 9.621959063112e+17,
              "user": {
                "private": 0
              },
              "likeId": 1.1745057644515e+18
            },
            {
              "username": "Icee+Juiceee",
              "verified": 0,
              "vanityUrls": [
                
              ],
              "created": "2015-02-03T21:18:04.000000",
              "userId": 1.1115735065103e+18,
              "user": {
                "private": 0
              },
              "likeId": 1.1745060776609e+18
            }
          ],
          "previousPage": null,
          "backAnchor": "",
          "anchor": 1.1745041705237e+18,
          "nextPage": 2,
          "size": 10
        },
        "loops": {
          "count": 1196718,
          "velocity": 0.45066666666667,
          "onFire": 0
        },
        "thumbnailUrl": "http:\/\/v.cdn.vine.co\/r\/videos\/556708D6651172332562849406976_31ec24cd3c6.1.5.8550682683537126991.mp4.jpg?versionId=YxLL_BIQl7khMqnL5E1i.MC05yCYEw4h",
        "explicitContent": 0,
        "myRepostId": 0,
        "description": "Dante experiences exposure therapy in \"Dante is afraid of carrots\" now up on my snapchat story!! Add KCJAMES (w\/ Barron Boedecker)",
        "verified": 1,
        "avatarUrl": "http:\/\/v.cdn.vine.co\/r\/avatars\/695860E7BB1024930754360446976_1bc248139da.4.5_C8V8ZtsNk59ff62kjqxwurA0drTfuXriqca9wqsdy2Og0kWF0R_z26aOlHGJdFJy.jpg?versionId=Hjfhs4aS_3I9F5KaLF8NpR8umxsq0_ZU",
        "comments": {
          "count": 1012,
          "anchorStr": "1174269150848241664",
          "records": [
            
          ],
          "previousPage": null,
          "backAnchor": "",
          "anchor": 1.1742691508482e+18,
          "nextPage": 2,
          "size": 10
        },
        "entities": [
          {
            "vanityUrls": [
              "BarronBoedecker"
            ],
            "title": "Barron Boedecker",
            "range": [
              113,
              129
            ],
            "link": "vine:\/\/user-id\/932127810728894464",
            "type": "mention",
            "id": 9.3212781072889e+17
          }
        ],
        "videoLowURL": "http:\/\/v.cdn.vine.co\/r\/videos_r2\/556708D6651172332562849406976_31ec24cd3c6.1.5.8550682683537126991.mp4?versionId=KqLIqqHlx.IS3Y9Wsm2yCQHManvsB4M2",
        "blocked": 0,
        "username": "KC James",
        "videoWebmUrl": null,
        "vanityUrls": [
          "KcJames"
        ],
        "tags": [
          
        ],
        "permalinkUrl": "https:\/\/vine.co\/v\/OTYhudjHFQg",
        "following": 0,
        "postId": 1.1723330193826e+18,
        "videoUrl": "http:\/\/v.cdn.vine.co\/r\/videos\/556708D6651172332562849406976_31ec24cd3c6.1.5.8550682683537126991.mp4?versionId=_kpDHvNrtt9RCz369S.Gwqvk.krCENSH",
        "followRequested": 0,
        "created": "2015-01-28T21:23:06.000000",
        "shareUrl": "https:\/\/vine.co\/v\/OTYhudjHFQg",
        "profileBackground": "0xffaf40",
        "promoted": 0,
        "reposts": {
          "count": 5705,
          "anchorStr": "1174492004609359872",
          "records": [
            
          ],
          "previousPage": null,
          "backAnchor": "",
          "anchor": 1.1744920046094e+18,
          "nextPage": 2,
          "size": 10
        }
      }
  },
  "success": true,
  "error": ""
}
	 */

		public int getCount() {
			return count;
		}

		public void setCount(int count) {
			this.count = count;
		}

		public String getAnchorStr() {
			return anchorStr;
		}

		public void setAnchorStr(String anchorStr) {
			this.anchorStr = anchorStr;
		}

		public List<records> getRecordsVar() {
			return recordsVar;
		}

		public void setRecordsVar(List<records> recordsVar) {
			this.recordsVar = recordsVar;
		}

		public String getPreviousPage() {
			return previousPage;
		}

		public void setPreviousPage(String previousPage) {
			this.previousPage = previousPage;
		}

		public String getBackAnchor() {
			return backAnchor;
		}

		public void setBackAnchor(String backAnchor) {
			this.backAnchor = backAnchor;
		}

		public String getAnchor() {
			return anchor;
		}

		public void setAnchor(String anchor) {
			this.anchor = anchor;
		}

		public int getNextPage() {
			return nextPage;
		}

		public void setNextPage(int nextPage) {
			this.nextPage = nextPage;
		}

		public int getSize() {
			return size;
		}

		public void setSize(int size) {
			this.size = size;
		}
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public data getDataVar() {
		return dataVar;
	}


	public void setDataVar(data dataVar) {
		this.dataVar = dataVar;
	}


	public boolean isSuccess() {
		return success;
	}


	public void setSuccess(boolean success) {
		this.success = success;
	}


	public String getError() {
		return error;
	}


	public void setError(String error) {
		this.error = error;
	}
}
