package com.climbtogether.climby.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Null;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_reservation")
public class Reservation implements Serializable {

	private static final long serialVersionUID = 6936124757433460309L;

	@Id
	@SequenceGenerator(name = "idReservationSeqGenerator", sequenceName = "sc_reservation", allocationSize = 1)
	@GeneratedValue(generator = "idReservationSeqGenerator")
	private Integer id_reservation;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_user", foreignKey = @ForeignKey(name = "fk_core_id_user"))
	private User passenger;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_travel", foreignKey = @ForeignKey(name = "fk_core_id_travel"))
	private Travel travel;
	
	@Column(name = "reservationStatus")
	private Boolean reservationStatus;
	
	@Column(name = "valuationStatus")
	private Boolean valuationStatus;
	
	@OneToOne
	@JoinColumn(name = "id_message", nullable = true)
	private Message message;
	

	@Column(name = "date_reservation", nullable = false)
	private LocalDateTime reservationDate;

}
