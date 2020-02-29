<html xmlns='http://www.w3.org/1999/xhtml'>
<head>
<title>打印页</title>
<style type='text/css'>

body {
	font-size: 20px;
}

.signature {
	max-height: 60px;
	min-height: 20px;
	width: auto;
}

.txtInput {
	width: 100%;
	word-break: break-all;
	word-wrap: break-word;
	border: 0;
	font-size: 20px;
	border-bottom: 1px solid black;
	font-family: FangSong;
}

.uploadImg {
	margin-top: 5px;
}

.uploadImg ul {
	width: 100%;
	float: left;
	margin: 0;
	padding: 0;
}

.uploadImg li {
	list-style: none;
	width: 110px;
	float: left;
	overflow: hidden;
}
</style>
</head>
<body>
	<form method='post' action='' id='form1'>
		<div id='dvData2'
			style='padding:0 10px;line-height:1em;font-family:SimSun;'>
			<div
				style='text-align: center; font-size: 32px;font-weight:bold;height:55px;padding-top:105px;    '>
				<span>食品生产经营日常监督检查要点表（告知页）</span>
			</div>
			<table
				style='width: 100%; border: 1px black solid; padding: 20px;font-family:SimSun;line-height:2em;font-size:20px;margin-top:55px;'>
				<tr>
					<td>
						<div style=' word-break: break-all; word-wrap:  break-word;'>
							被检查单位：<span id='spanCheckUnitName'
								style='text-decoration: underline;padding-right:10px;'>吴江区震泽镇天池饭店</span>
						</div>
					</td>
				</tr>
				<tr>
					<td style='padding-top:8px;'>地址：<span
						id='spanCheckUnitAddress' style='text-decoration: underline;'>江苏省苏州市吴江区震泽镇贯桥村新农村门面房</span>
					</td>
				</tr>
				<tr>
					<td style='padding-top:8px;'><span>检查人员及执法证件名称、编号：</span>周超(JSZF05110223),杨定登(JSZF05110200)</td>
				</tr>
				<tr>
					<td style='padding-top:8px;'>
						<div>
							检查时间：&nbsp;<span id='spanCheckDateTime'
								style='text-decoration: underline;'>2019年01月03日</span>
						</div>
					</td>
				</tr>
				<tr>
					<td style='padding-top:8px;'>
						<div>
							检查地点：<span id='spanCheckAddress' onclick='clickt($(this))'
								style='text-decoration: underline;'>江苏省苏州市吴江区震泽镇贯桥村新农村门面房</span>
						</div>
					</td>
				</tr>
				<tr>
					<td style='padding-top:8px;'>
						<div>告知事项：</div>
					</td>
				</tr>
				<tr>
					<td style='padding-top:4px;'>
						<div
							style='text-indent: 2em; word-break: break-all; word-wrap:  break-word;line-height:2em;'>
							我们是<span id='spanSupervisorUnitName' onclick='clickt ($(this))'
								style='text-decoration: underline;'>吴江区市场监督管理局震泽分局</span>
							监督检查人员，现 出示执法证件。我们依法对你（单位）进行日常监督检查，请予配合。
						</div>
						<div
							style='text-indent: 2em; word-break: break-all; word-wrap:  break-word;line-height:2em;padding-top:4px;'>
							依照法律规定，监督检查人员少于两人或者所出示的执法证件与其身份
							不符的，你（单位）有权拒绝检查；对于监督检查人员有下列情形之一的，你（单位）有权申请回避：
							（1）系当事人或当事人的近亲属；（2）与本人或本人近亲属有利害关系；（3）与当事人有其他关系， 可能影响公正执法的。</div>
					</td>
				</tr>
				<tr>
					<td style='padding-top:70px;'>
						<div style='text-indent: 2em;'>问：你（单位）是否申请回避？</div>
						<div style='text-indent: 2em;padding-top:8px;'>
							答： <input type='checkbox' disabled='disabled' />申请回避<input
								type='checkbox' disabled='disabled' checked='checked'
								style='margin-left:40px;' />不申请回避
						</div>
					</td>
				</tr>
				<tr>
					<td>
						<table style='width: 100%;height:100px;font-size:20px;'>
							<tr>
								<td style='padding-top:190px;'><table style='width:100%;'>
										<tr>
											<td style='width:160px;font-size:20px;'>被检查单位签字：</td>
											<td>
												<div
													style='width:235px;border-bottom: 1px solid black;color: black;min-height: 20px;'></div>
											</td>
										</tr>
										<tr>
											<td></td>
											<td style='text-align:center;padding-top:20px;'><input
												readonly='readonly' value='2019'
												style='width: 50px; text-align:  center; border: 0px;' /><span
												style='font-size:20px;'>年</span><input value='1'
												style='width: 26px; text-align: center; border:  0px;' /><span
												style='font-size:20px;'>月</span><input readonly='readonly'
												value='3'
												style='width: 26px; text-align: center; border: 0px;' /><span
												style='font-size:20px;'>日</span></td>
										</tr>
									</table></td>
								<td>
									<table style='width: 100%; '>
										<tr>
											<td style='padding-top:190px;'><table
													style='width:100%;'>
													<tr>
														<td style='width:145px;font-size:20px;'>检查人员签字：</td>
														<td>
															<div
																style='width:235px;border-bottom: 1px solid black;color: black;min-height: 20px;'></div>
														</td>
													</tr>
													<tr>
														<td></td>
														<td style='text-align:center;padding-top:20px;'>2019年</span><input
															readonly='readonly' value='1'
															style='width: 26px; text-align: center; border:  0px;' /><span
															style='font-size:20px;'>月</span><input
															readonly='readonly' value='3'
															style='width: 26px; text-align: center; border: 0px;' /><span
															style='font-size:20px;'>日</span></td>
													</tr>
												</table></td>
										</tr>
									</table>
									</div>
									</form>
</body>
</html>