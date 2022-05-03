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
                  :key="product.productId"
                >
                  <router-link
                    :to="{
                      name: 'ProductDetailPage',
                      params: { productId: product.productId.toString() },
                    }"
                  >
                    <div class="product-card">
                      <div class="product-card-image">
                        <img
                          alt="신발"
                          v-if="product.fileName != null"
                          :src="require(`@/assets/image/${product.fileName}`)"
                        />
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
                  </router-link>
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
export default {
  name: "ProductCard",
  props: {
    productList: {
      type: Array,
    },
    listArray: {
      type: Array,
      required: true,
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
}
</script>
<style lang="scss" scoped>
@import "~@/assets/scss/layout/product";
@import "~@/assets/scss/layout/product-recommendation";
</style>
