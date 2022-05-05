import {
  FETCH_MEMBER_LIST,
  FETCH_MEMBER,
  FETCH_PRODUCT_LIST,
  FETCH_PRODUCT,
  FETCH_PRODUCT_COMMENT_LIST,
  FETCH_MANAGER,
  FETCH_MANAGERAUTH,
  FETCH_MANAGER_LIST,
  FETCH_MANAGERAUTH_LIST,
  FETCH_CART_LIST,
} from "./mutation-types"

import axios from "axios"

export default {
  fetchMemberList({ commit }) {
    return axios.get("http://localhost:8888/Member/list").then((res) => {
      commit(FETCH_MEMBER_LIST, res.data)
    })
  },
  fetchMember({ commit }, memberNo) {
    return axios.get(`http://localhost:8888/Member/${memberNo}`).then((res) => {
      commit(FETCH_MEMBER, res.data)
    })
  },
  fetchProductList({ commit }) {
    return axios.get("http://localhost:8888/product/list").then((res) => {
      commit(FETCH_PRODUCT_LIST, res.data)
    })
  },
  fetchProduct({ commit }, productId) {
    return axios
      .get(`http://localhost:8888/product/${productId}`)
      .then((res) => {
        commit(FETCH_PRODUCT, res.data)
      })
  },
  fetchProductCommentList({ commit }, productId) {
    return axios
      .get(`http://localhost:8888/product/comment/list/${productId}`)
      .then((res) => {
        commit(FETCH_PRODUCT_COMMENT_LIST, res.data)
      })
  },
  fetchManagerAuthList({ commit }) {
    return axios.get("http://localhost:8888/manage/authLists").then((res) => {
      commit(FETCH_MANAGERAUTH_LIST, res.data)
    })
  },
  fetchManagerList({ commit }) {
    return axios.get("http://localhost:8888/manage/lists").then((res) => {
      commit(FETCH_MANAGER_LIST, res.data)
    })
  },
  fetchManager({ commit }, memberNo) {
    console.log("memberNo =" + memberNo)
    return axios
      .get(`http://localhost:8888/manage/manager/${memberNo}`)
      .then((res) => {
        commit(FETCH_MANAGER, res.data)
        commit(FETCH_MANAGERAUTH, res.data.authList[0])
      })
  },
  fetchCartList({ commit }, memberNo) {
    console.log("memberNo =" + memberNo)
    return axios
      .get(`http://localhost:8888/cart/cartList/${memberNo}`)
      .then((res) => {
        commit(FETCH_CART_LIST, res.data)
      })
  },
}
