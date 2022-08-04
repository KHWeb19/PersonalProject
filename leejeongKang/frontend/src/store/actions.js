import {
  FETCH_BOARD_LIST,
  FETCH_BOARD,
  FETCH_MEMBER,
  FETCH_DOCTOR_LIST,
  FETCH_DOCTOR,
  FETCH_APPOINTMENT_LIST,
  FETCH_APPOINTMENT,
  FETCH_COMMENT_LIST
} from './mutation-types'

import axios from 'axios'

export default {
  fetchMember ({ commit }, memberNo) {
    return axios.get(`http://localhost:7777/member/${memberNo}`)
      .then((res) => {
        commit(FETCH_MEMBER, res.data)
      })
  },
  fetchBoardList ({ commit }) {
    return axios.get('http://localhost:7777/board/list')
      .then((res) => {
        commit(FETCH_BOARD_LIST, res.data)
      })
  },
  fetchBoard ({ commit }, boardNo) {
    return axios.get(`http://localhost:7777/board/${boardNo}`)
      .then((res) => {
        commit(FETCH_BOARD, res.data)
      })
  },
  fetchDoctorList ({ commit }) {
    return axios.get('http://localhost:7777/doctor/list')
      .then((res) => {
        commit(FETCH_DOCTOR_LIST, res.data)
      })
  },
  fetchDoctor ({ commit }, doctorNo) {
    return axios.get(`http://localhost:7777/doctor/${doctorNo}`)
      .then((res) => {
        commit(FETCH_DOCTOR, res.data)
      })
  },
  fetchAppointmentList ({ commit }) {
    return axios.get(`http://localhost:7777/appointment/list`)
      .then((res) => {
        commit(FETCH_APPOINTMENT_LIST, res.date)
      })
  },
  fetchAppointment ({ commit }, memberNo) {
    return axios.get(`http://localhost:7777/appointment/${memberNo}`)
      .then((res) => {
        commit(FETCH_APPOINTMENT, res.data)
      })
  },
  fetchCommentList ({ commit }, boardNo) {
    return axios.get(`http://localhost:7777/qnaComment/${boardNo}`)
      .then((res) => {
        commit(FETCH_COMMENT_LIST, res.data)
      })
  }
}
