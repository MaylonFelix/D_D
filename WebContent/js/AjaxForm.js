/**
 * Bootstrap Alerts - Function Name - showalert() Inputs - message,alerttype
 * Example - showalert("Invalid Login","alert-error") Types of alerts --
 * "alert-error","alert-success","alert-info" Reuired - You only need to add a
 * alert_placeholder div in your html page wherever you want to display these
 * alerts Written On - 14-Jun-2013
 */
function showalert(message, alerttype) {

	$('#alert_placeholder').append(
			'<div id="alertdiv" class="alert ' + alerttype
					+ '"><a class="close" data-dismiss="alert">×</a><span>'
					+ message + '</span></div>')

	setTimeout(function() { // this will automatically close the alert and
							// remove this if the users doesnt close it in 5
							// secs

		// $('#alertdiv').fadeOut('slow');
		$("#alertdiv").remove();

	}, 6000);
}

$(document).ready(function() {

					$("#alert").click(showalert("Alerta!", "alert-error"));

					// Stops the submit request
					$("#myAjaxRequestForm").submit(function(e) {
						e.preventDefault();
					});

					// checks for the button click event
					$("#salvar")
							.click(
									function(e) {
										/*
										 * dataJson = {nome : $('#nome').val(),
										 * descricao :$('#descricao').val()};
										 */
										dataString = $("#myAjaxRequestForm").serialize();

										$.ajax({
													contentType : "application/x-www-form-urlencoded; charset=UTF-8",
													type : "POST", // Foi só
																	// trocar
																	// para POST
																	// que
																	// funcionou.
													url : "../CadastraEntidadeAjax",
													data : dataString,
													cache : false,
													dataType : "json", // dado
																		// que
																		// eu
																		// recebo
																		// do
																		// servidor
													scriptCharset : "utf-8",
													// if received a response
													// from the server
													success : function(data,
															textStatus, jqXHR) {
														if (data.success) {
															$("#ajaxResponse").html("");
															console
																	.log(data.entidade.nome);
															console
																	.log(data.entidade.descricao);
															$("#ajaxResponse")
																	.append(
																			"<b>Nome:</b> "
																					+ data.entidade.nome
																					+ "");
															$("#ajaxResponse")
																	.append(
																			" <b>Descrição:</b> "
																					+ data.entidade.descricao
																					+ "");
															// window.alert("Descrição:
															// "+
															// data.entidade.descricao+
															// "");
															$("#feedback")
																	.append(
																			data.entidade.nome
																					+ " cadastrada com sucesso.");
														}
														// display error message
														else {
															$("#ajaxResponse")
																	.html(
																			"<div><b>Erro!</b></div>");
														}
													},

													// If there was no response
													// from the server
													error : function(jqXHR,
															textStatus,
															errorThrown) {
														console
																.log("Something really bad happened "
																		+ textStatus);
														$("#ajaxResponse")
																.html(
																		jqXHR.responseText);
													},

													// capture the request
													// before it was sent to
													// server
													beforeSend : function(
															jqXHR, settings) {
														// disable the button
														// until we get the
														// response
														$('#salvar').attr(
																"disabled",
																true);
													},

													// this is called after the
													// response or error
													// functions are finished so
													// that we can take some
													// action
													complete : function(jqXHR,
															textStatus) {
														// enable the button
														$('#salvar').attr(
																"disabled",
																false);
													}

												});
									});

				});
