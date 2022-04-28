<template>
  <body>
    <div class="container">
      <div class="row">
        <div class="col-sm-4 col-md-6 col-lg-7">
          <div class="product-carousel" role="region">
            <div class="product-carousel-slider">
              <header class="member-header">
                <h2>{{ product.productName }}</h2>
              </header>
              <ol class="slider-list">
                <li
                  class="slider-item"
                  role="tabpanel"
                  aria-labelledby="product-carousel-tab-1"
                >
                  <figure>
                    <img
                      v-if="product.fileName != null"
                      :src="require(`@/assets/image/${product.fileName}`)"
                      alt=""
                    />
                    <figcaption class="visually-hidden">
                      {{ product.productName }}
                    </figcaption>
                  </figure>
                </li>
                <li
                  class="slider-item"
                  role="tabpanel"
                  aria-labelledby="product-carousel-tab-2"
                >
                  <figure>
                    <img
                      v-if="product.fileName != null"
                      :src="require(`@/assets/image/${product.fileName}`)"
                      alt=""
                    />
                    <figcaption class="visually-hidden">
                      {{ product.productName }}
                    </figcaption>
                  </figure>
                </li>
                <li
                  class="slider-item"
                  role="tabpanel"
                  aria-labelledby="product-carousel-tab-3"
                >
                  <figure>
                    <img
                      v-if="product.fileName != null"
                      :src="require(`@/assets/image/${product.fileName}`)"
                      alt=""
                    />
                    <figcaption class="visually-hidden">
                      {{ product.productName }}
                    </figcaption>
                  </figure>
                </li>
                <li
                  class="slider-item"
                  role="tabpanel"
                  aria-labelledby="product-carousel-tab-4"
                >
                  <figure>
                    <img
                      v-if="product.fileName != null"
                      :src="require(`@/assets/image/${product.fileName}`)"
                      alt=""
                    />
                    <figcaption class="visually-hidden">
                      {{ product.productName }}
                    </figcaption>
                  </figure>
                </li>
              </ol>
            </div>

            <div class="product-carousel-thumbnail">
              <ol class="thumbnail-list" role="tablist">
                <li
                  class="thumbnail-item"
                  id="product-carousel-tab-1"
                  role="tab"
                >
                  <button type="button">
                    <img
                      v-if="product.fileName != null"
                      :src="require(`@/assets/image/${product.fileName}`)"
                      alt="1번 이미지"
                    />
                  </button>
                </li>
                <li
                  class="thumbnail-item"
                  id="product-carousel-tab-2"
                  role="tab"
                >
                  <button type="button">
                    <img
                      v-if="product.fileName != null"
                      :src="require(`@/assets/image/${product.fileName}`)"
                      alt="2번 이미지"
                    />
                  </button>
                </li>
                <li
                  class="thumbnail-item"
                  id="product-carousel-tab-3"
                  role="tab"
                >
                  <button type="button">
                    <img
                      v-if="product.fileName != null"
                      :src="require(`@/assets/image/${product.fileName}`)"
                      alt="3번 이미지"
                    />
                  </button>
                </li>
                <li
                  class="thumbnail-item"
                  id="product-carousel-tab-4"
                  role="tab"
                >
                  <button type="button">
                    <img
                      v-if="product.fileName != null"
                      :src="require(`@/assets/image/${product.fileName}`)"
                      alt="4번 이미지"
                    />
                  </button>
                </li>
              </ol>
            </div>
          </div>
        </div>

        <div class="col-sm-4 col-md-6 col-lg-5">
          <section class="product-info">
            <header class="product-info-header">
              <h1 class="info-title">
                {{ product.productName }}
              </h1>
              <div class="info-review">
                <div class="star-rating">
                  <i class="ic-star is-active"></i>
                  <i class="ic-star is-active"></i>
                  <i class="ic-star is-active"></i>
                  <i class="ic-star is-active"></i>
                  <i class="ic-star is-active"></i>
                </div>
              </div>
            </header>

            <!-- NOTE: 모바일용 가격 -->
            <div class="product-info-price sm-only">
              <div class="info-original-price">
                <div class="discount-rate">
                  <span class="rate">34</span>
                  <span class="percent">%</span>
                </div>

                <div class="price-off">
                  <strong class="amount">49,900</strong>
                  <span class="currency sm-hidden">원</span>
                </div>
              </div>

              <div class="info-sale-price">
                <div class="price-20">
                  <strong class="amount">32,900</strong>
                  <span class="currency">원</span>
                </div>
              </div>
            </div>

            <!-- NOTE: 태블릿 이후 가격 -->
            <div class="product-info-price sm-hidden">
              <div class="info-price-wrapper">
                <div class="discount-rate">
                  <span class="percent">{{ product.discount }}%</span>
                </div>

                <div class="info-price">
                  <div class="price-off">
                    <strong class="price">{{
                      product.productDiscountPrice | pricePoint
                    }}</strong>
                  </div>

                  <div class="info-sale-price">
                    <div class="price-32">
                      <strong class="price-off">2</strong>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </section>

          <form class="order-form lg-only" action="/" method="POST">
            <dl class="order-summary">
              <dt>주문금액</dt>
              <dd>
                <output for="select-1 select-2">
                  <div class="price-20">
                    <strong class="amount">{{ product.productPrice }}원</strong>
                  </div>
                </output>
              </dd>
            </dl>
            <div class="button-group">
              <button
                @click="addToCart(product.productId)"
                class="btn-outlined btn-55"
                type="button"
              >
                장바구니
              </button>
              <button class="btn-primary btn-55" type="submit">바로구매</button>
            </div>
          </form>
        </div>
      </div>
    </div>
  </body>
</template>
<script>
import axios from "axios"
export default {
  name: "ProductDetail",
  props: {
    product: {
      type: Object,
      require: true,
    },
  },
  data() {
    return {
      productName: this.product.productName,
      productPrice: this.product.productPrice,
      productId: this.product.productId,
      discount: this.product.discount,
      fileName: this.product.fileName,
      userInfo: this.$store.state.userInfo,
      comment: "",
    }
  },
  methods: {
    addToCart(memberNo) {
      if (this.userInfo != null) {
        const { product } = this
        axios
          .post(
            `http://localhost:8888/Member/addToCart/register/${memberNo}`,
            product
          )
          .then((res) => {
            if (res.data) {
              alert("장바구니 등록 성공")
              this.$router.go()
            }
          })
          .catch(() => {
            alert("등록 실패")
          })
      } else {
        alert("로그인 후 이용해주세요.")
      }
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
@import "~@/assets/scss/components/product-detail";
@import "~@/assets/scss/components/product-info";
</style>
