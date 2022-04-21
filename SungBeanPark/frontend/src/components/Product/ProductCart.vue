<template>
  <ul class="cart-content-list">
    <li v-for="cart in CartList" :key="cart.id" class="cart-content-item">
      <article class="cart-content-product">
        <ul class="cart-content-option">
          <li class="cart-content-option-list">
            <article class="cart-content-article">
              <div>
                <div class="product-small-card select">
                  <input type="checkbox" />
                </div>
                <div class="product-small-card">
                  <a class="product-small-item" href="/">
                    <div class="product-small-img">
                      <picture class="product-small-item picture">
                        <img :src="product.image" alt="" />
                      </picture>
                    </div>
                    <div class="product-small-item content">
                      {{ product.productName }}
                      <h3 class="product-small-item title"></h3>
                      <p>무료배송 &nbsp;|&nbsp; 화물택배</p>
                    </div>
                  </a>
                  <button class="product-small-delete">
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
                              <option value="1">
                                {{ product.productNum }}
                              </option>
                              <option value="2">
                                {{ product.productNum + 1 }}
                              </option>
                              <option value="3">
                                {{ product.productNum + 2 }}
                              </option>
                              <option value="4">
                                {{ product.productNum + 3 }}
                              </option>
                              <option value="5">
                                {{ product.productNum + 4 }}
                              </option>
                              <option value="6">
                                {{ product.productNum + 5 }}
                              </option>
                              <option value="7">
                                {{ product.productNum + 6 }}
                              </option>
                              <option value="8">
                                {{ product.productNum + 7 }}
                              </option>
                              <option value="9">
                                {{ product.productNum + 8 }}
                              </option>
                            </select>
                            <span>
                              <i class="ic-caret" aria-hidden></i>
                            </span>
                          </div>

                          <output class="checkout-output" for="checkout-item-1">
                            <div class="price">
                              <strong class="price">{{
                                product.productPrice | pricePoint
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
                    <button class="cart-content-footer option" type="button">
                      옵션변경
                    </button>
                    <button class="cart-content-footer pay" type="button">
                      바로구매
                    </button>
                  </span>
                  <strong class="price">{{
                    (product.productPrice * product.productNum) | pricePoint
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
</template>
<script>
export default {
  name: "ProductCart",

  props: {
    CartList: {
      type: Array,
    },
    computed: {
      cartList() {
        return this.$store.state.cartList
      },
    },
    created() {
      this.mainCartList()
    },
    data() {},

    filters: {
      pricePoint: function (value) {
        return value.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",")
      },
      ratingPoint: function (value) {
        return value.toString().replace(/\B(?=(\d{1})+(?!\d))/g, ".")
      },
    },
  },
}
</script>
<style lang="scss" scoped>
@import "~@/assets/scss/layout/cart";
@import "~@/assets/scss/components/checkout-card";
@import "~@/assets/scss/components/product-small";
</style>
