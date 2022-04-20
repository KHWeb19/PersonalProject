<template>
  <div>
    <section class="product-section product-recommendation">
      <div class="container">
        <div class="row">
          <div class="col-sm-4">
            <header class="product-section-header">
              <h2 class="title">Shoes</h2>
            </header>

            <div class="product-section-content">
              <ul class="product-list">
                <li
                  class="product-item"
                  v-for="product in productList"
                  :key="product.productName"
                >
                  <a>
                    <div class="product-card">
                      <div class="product-card-image">
                        <img alt="신발" />
                        <button>
                          <i class="ic-bookmark"></i>
                        </button>
                      </div>

                      <h1 class="product-card-title">
                        {{ product.productName }}
                      </h1>

                      <div class="product-card-price">
                        <span class="percent">{{ product.discount }}%</span>
                        <strong class="price">{{
                          product.productPrice | pricePoint
                        }}</strong>

                        <strong class="price-off">{{
                          product.productDiscountPrice | pricePoint
                        }}</strong>
                      </div>
                      <div class="product-card-subtitle">
                        <span class="only">{{ product.gender }}</span>
                      </div>

                      <dl class="product-card-detail">
                        <div class="rating">
                          <dt>
                            <i class="ic-star"></i>
                            <span class="visually-hidden">평점</span>
                          </dt>
                          <dd>
                            {{ product.rating | ratingPoint }}
                          </dd>
                        </div>
                      </dl>
                    </div>
                  </a>
                  <button @click="Cart(product)">장바구니</button>
                </li>
              </ul>
            </div>
          </div>
        </div>
      </div>
    </section>
  </div>
</template>
<script>
import axios from "axios"
import { mapActions, mapState } from "vuex"
export default {
  name: "ProductCard",

  props: {
    productList: {
      type: Array,
    },
  },
  mounted() {
    this.fetchProductList()
  },
  methods: {
    ...mapActions(["fetchProductList"]),

    Cart(product) {
      const { productName, productPrice } = product
      axios
        .post(
          `http://localhost:8888/Member/addCart/${this.$store.state.loginMemberNo}`,
          { productName, productPrice }
        )
        .then(() => {
          alert("장바구니에 추가되었습니다.")
          this.$router.go()
        })
        .catch((err) => {
          alert(err.response.data.message)
        })
    },
  },
  computed: {
    ...mapState(["members", "User", "loginMemberNo"]),
  },

  filters: {
    pricePoint: function (value) {
      return value.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",")
    },
    ratingPoint: function (value) {
      return value.toString().replace(/\B(?=(\d{1})+(?!\d))/g, ".")
    },
  },
}
</script>
<style lang="scss">
@import "~@/assets/scss/layout/product";
@import "~@/assets/scss/layout/product-section";
</style>
