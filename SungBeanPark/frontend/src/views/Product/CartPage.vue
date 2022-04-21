<template>
  <body>
    <header-layout></header-layout>
    <div class="cart">
      <div class="container">
        <div class="row">
          <div class="cart-content-wrap col-sm-4 col-md-7 col-lg-8">
            <div class="cart-content">
              <div class="cart-content-header">
                <div class="cart-content-header left">
                  <label for="">
                    <input type="checkbox" />
                  </label>
                  <span>모두 선택</span>
                </div>

                <span class="cart-content-header right">
                  <button class="cart-content-hedaer delete">선택삭제</button>
                </span>
              </div>
            </div>
            <product-cart :CartList="CartList"></product-cart>
          </div>
          <div class="cart-sidebar-wrap col-sm-4 col-md-5 col-lg-4">
            <div class="cart-sidebar-sticky">
              <dl class="cart-sidebar">
                <div class="cart-sidebar-price">
                  <dt>총 상품 금액</dt>
                  <dd><span class="number"></span>원</dd>
                </div>
                <div class="cart-sidebar-price">
                  <dt>총 배송비</dt>
                  <dd>+<span class="number">0</span>원</dd>
                </div>
                <div class="cart-sidebar-price">
                  <dt>총 할인금액</dt>
                  <dd>-<span class="number"></span>원</dd>
                </div>
                <div class="cart-sidebar-price total">
                  <dt>결제금액</dt>
                  <dd><span class="number"></span>원</dd>
                </div>
              </dl>
              <div class="cart-sidebar-btn">
                <button class="btn-black btn-46">상품 구매하기</button>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <footer-layout></footer-layout>
  </body>
</template>
<script>
import HeaderLayout from "@/components/Header/HeaderLayout.vue"
import FooterLayout from "@/components/Footer/FooterLayout.vue"
import ProductCart from "@/components/Product/ProductCart.vue"
import { mapActions, mapState } from "vuex"
export default {
  name: "CartPage",
  components: { HeaderLayout, FooterLayout, ProductCart },
  props: {
    memberNo: {
      type: String,
      required: true,
    },
  },
  computed: {
    ...mapState(["CartList"]),
  },
  methods: {
    ...mapActions(["fetchCartList"]),
  },
  created() {
    this.fetchCartList(this.memberNo)
  },
}
</script>
<style lang="scss" scoped>
@import "~@/assets/scss/layout/cart";
@import "~@/assets/scss/components/checkout-card";
@import "~@/assets/scss/components/product-small";
</style>
