<template>
  <div class="cart">
    <div class="container">
      <div class="row">
        <div class="cart-content-wrap col-sm-4 col-md-7 col-lg-8">
          <div class="cart-content">
            <div class="cart-content-header">
              <div class="cart-content-header left">
                <label for="">
                  <input
                    type="checkbox"
                    v-model="allChecked"
                    @click="checkedAll($event.target.checked)"
                  />
                </label>
                <span>모두 선택</span>
              </div>

              <span class="cart-content-header right">
                <button class="cart-content-hedaer delete">선택삭제</button>
              </span>
            </div>
          </div>
          <ul class="cart-content-list">
            <li
              v-for="product in cartList"
              :key="product.productId"
              class="cart-content-item"
            >
              <article class="cart-content-product">
                <ul class="cart-content-option">
                  <li class="cart-content-option-list">
                    <article class="cart-content-article">
                      <div>
                        <div class="product-small-card select">
                          <input
                            :value="product.productId"
                            v-model="product.selected"
                            @change="selected($event)"
                            type="checkbox"
                          />
                        </div>
                        <div class="product-small-card">
                          <a class="product-small-item" href="/">
                            <div class="product-small-img">
                              <picture class="product-small-item picture">
                                <img
                                  v-if="product.fileName != null"
                                  :src="
                                    require(`@/assets/image/${product.fileName}`)
                                  "
                                  alt=""
                                />
                              </picture>
                            </div>
                            <div class="product-small-item content">
                              {{ product.productName }}
                              <h3 class="product-small-item title"></h3>
                              <p>무료배송 &nbsp;|&nbsp; 화물택배</p>
                            </div>
                          </a>
                          <button
                            class="product-small-delete"
                            @click="onDeleteProduct(cartList[0].cart[0].cartNo)"
                          >
                            <i class="ic-close"></i>
                          </button>
                        </div>

                        <div class="order-checkouts">
                          <ul class="checkout-list">
                            <li class="checkout-item">
                              <div class="checkout-card">
                                <header class="checkout-header">
                                  <h4 class="checkout-title">
                                    {{ product.productName }}
                                  </h4>
                                  <button
                                    class="delete-button"
                                    type="button"
                                    aria-label="해당 상품을 삭제하기"
                                  >
                                    <i class="ic-close" aria-hidden></i>
                                  </button>
                                </header>

                                <div class="checkout-footer">
                                  <div class="checkout-select">
                                    <select id="checkout-item-1">
                                      <option value="1"></option>
                                      <option value="2"></option>
                                      <option value="3"></option>
                                      <option value="4"></option>
                                      <option value="5"></option>
                                      <option value="6"></option>
                                      <option value="7"></option>
                                      <option value="8"></option>
                                      <option value="9"></option>
                                    </select>
                                    <span>
                                      <i class="ic-caret" aria-hidden></i>
                                    </span>
                                  </div>

                                  <output
                                    class="checkout-output"
                                    for="checkout-item-1"
                                  >
                                    <div class="price">
                                      <strong class="price">{{
                                        product.productDiscountPrice
                                          | pricePoint
                                      }}</strong>
                                    </div>
                                  </output>
                                </div>
                              </div>
                            </li>
                          </ul>
                        </div>

                        <div class="cart-content-footer">
                          <span class="cart-content-footer btn-group">
                            <button
                              class="cart-content-footer option"
                              type="button"
                            >
                              옵션변경
                            </button>
                            <button
                              class="cart-content-footer pay"
                              type="button"
                            >
                              바로구매
                            </button>
                          </span>
                          <strong class="price">{{
                            (product.productPrice * product.productNum)
                              | pricePoint
                          }}</strong>
                        </div>
                      </div>
                    </article>
                  </li>
                </ul>
                <footer class="cart-sidebar-delivery">
                  <p>배송비 무료</p>
                </footer>
              </article>
            </li>
          </ul>
        </div>

        <div class="cart-sidebar-wrap col-sm-4 col-md-5 col-lg-4">
          <div class="cart-sidebar-sticky">
            <dl class="cart-sidebar">
              <div class="cart-sidebar-price">
                <dt>총 상품 금액</dt>
                <dd>
                  <span class="number">{{ sumProductPrice | pricePoint }}</span
                  >원
                </dd>
              </div>
              <div class="cart-sidebar-price">
                <dt>총 배송비</dt>
                <dd>+<span class="number">0</span>원</dd>
              </div>
              <div class="cart-sidebar-price">
                <dt>총 할인금액</dt>
                <dd>
                  -<span class="number">{{
                    sumProductDiscountPrice | pricePoint
                  }}</span
                  >원
                </dd>
              </div>
              <div class="cart-sidebar-price total">
                <dt>결제금액</dt>
                <dd>
                  <span class="number">{{ totalPrice | pricePoint }}</span
                  >원
                </dd>
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
</template>
<script>
import axios from "axios"
import { mapState } from "vuex"
export default {
  name: "ProductCart",
  props: {
    cartList: {
      type: Array,
    },
  },
  data() {
    return {
      allChecked: false,
    }
  },

  computed: {
    ...mapState["member"],

    sumProductPrice() {
      let sumProductPrice = 0
      for (let i = 0; i < this.cartList.length; i++) {
        sumProductPrice += this.cartList[i].productPrice
      }

      return sumProductPrice
    },
    sumProductDiscountPrice() {
      let sumProductDiscountPrice = 0
      for (let i = 0; i < this.cartList.length; i++) {
        sumProductDiscountPrice +=
          this.cartList[i].productPrice * (this.cartList[i].discount * 0.01)
      }

      return sumProductDiscountPrice
    },
    totalPrice() {
      let totalPrice = 0
      for (let i = 0; i < this.cartList.length; i++) {
        totalPrice +=
          this.cartList[i].productPrice -
          this.cartList[i].productPrice * (this.cartList[i].discount * 0.01)
      }

      return totalPrice
    },
  },

  filters: {
    pricePoint: function (value) {
      return value.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",")
    },
    ratingPoint: function (value) {
      return value.toString().replace(/\B(?=(\d{1})+(?!\d))/g, ".")
    },
  },
  methods: {
    onDeleteProduct(cartNo) {
      console.log(cartNo)
      axios
        .delete(`http://localhost:8888/cart/cartRemove/${cartNo}`, {
          cartNo,
        })
        .then(() => {
          alert("삭제되었습니다.")
          this.$router.go()
        })
        .catch(() => {
          alert("삭제요청실패")
        })
    },
  },
}
</script>
<style lang="scss" scoped>
@import "~@/assets/scss/layout/cart";
@import "~@/assets/scss/components/checkout-card";
@import "~@/assets/scss/components/product-small";
</style>
