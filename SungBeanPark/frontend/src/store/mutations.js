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
  FETCH_AUTH_LIST,
} from "./mutation-types"

export default {
  [FETCH_MEMBER_LIST](state, members) {
    state.members = members
  },
  [FETCH_MEMBER](state, userInfo) {
    state.userInfo = userInfo
  },
  [FETCH_PRODUCT_LIST](state, productList) {
    state.productList = productList
  },
  [FETCH_PRODUCT](state, product) {
    state.product = product
  },
  [FETCH_PRODUCT_COMMENT_LIST](state, productComments) {
    state.productComments = productComments
  },
  [FETCH_MANAGER](state, manager) {
    state.manager = manager
  },
  [FETCH_MANAGER_LIST](state, managers) {
    state.managers = managers
  },
  [FETCH_MANAGERAUTH](state, memberAuth) {
    state.memberAuth = memberAuth
  },
  [FETCH_MANAGERAUTH_LIST](state, memberAuths) {
    state.memberAuths = memberAuths
  },
  [FETCH_AUTH_LIST](state, auths) {
    state.auths = auths
  },
  [FETCH_CART_LIST](state, cartList) {
    state.cartList = cartList
  },
}
