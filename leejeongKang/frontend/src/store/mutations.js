import {
  FETCH_MEMBER,
  FETCH_BOARD_LIST,
  FETCH_BOARD,
  FETCH_DOCTOR_LIST,
  FETCH_DOCTOR,
  FETCH_APPOINTMENT_LIST,
  FETCH_APPOINTMENT,
  FETCH_COMMENT_LIST
} from './mutation-types'

export default {
  [FETCH_MEMBER] (state, member) {
    state.member = member
  },
  [FETCH_BOARD_LIST] (state, boards) {
    state.boards = boards
  },
  [FETCH_BOARD] (state, board) {
    state.board = board
  },
  [FETCH_DOCTOR_LIST] (state, doctors) {
    state.doctors = doctors
  },
  [FETCH_DOCTOR] (state, doctor) {
    state.doctor = doctor
  },
  [FETCH_APPOINTMENT_LIST] (state, appointments) {
    state.appointments = appointments
  },
  [FETCH_APPOINTMENT] (state, appointment) {
    state.appointment = appointment
  },
  [FETCH_COMMENT_LIST] (state, comments) {
    state.comments = comments
  }
}
