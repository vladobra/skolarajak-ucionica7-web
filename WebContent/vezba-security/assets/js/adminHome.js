function setNumberOfRows(rows) {
	console.log("Rows:" + rows);
	 var now = new Date();
	 var time = now.getTime();
	 var expireTime = time + 96*1000*3600;
	 now.setTime(expireTime);
	 document.cookie = "rowsInTable=" + rows +";expires="+now.toGMTString();
	 location.reload();
}