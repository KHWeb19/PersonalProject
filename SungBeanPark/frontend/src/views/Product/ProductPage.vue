<template>
  <body>
    <Header-Layout></Header-Layout>
    <section class="product-section product-recommendation">
      <div class="container">
        <div class="row">
          <div class="col-sm-4">
            <header class="product-section-header">
              <h2 class="title">Shoes</h2>
            </header>

            <div class="product-section-content">
              <ul class="product-list">
                <li class="product-item" v-for="(data, i) in shoes" :key="i">
                  <a href="/">
                    <div class="product-card">
                      <div class="product-card-image">
                        <img :src="shoes[i].image" alt="신발" />
                        <button>
                          <i class="ic-bookmark"></i>
                        </button>
                      </div>

                      <h1 class="product-card-title">{{ shoes[i].title }}</h1>

                      <div class="product-card-price">
                        <span class="percent">{{ shoes[i].percent }}%</span>
                        <strong class="price">{{
                          shoes[i].price | pricePoint
                        }}</strong>
                        <strong class="price-off">{{
                          shoes[i].priceoff | pricePoint
                        }}</strong>
                      </div>
                      <div class="product-card-subtitle">
                        <span class="only">{{ shoes[i].only }}</span>
                      </div>

                      <dl class="product-card-detail">
                        <div class="rating">
                          <dt>
                            <i class="ic-star"></i>
                            <span class="visually-hidden">평점</span>
                          </dt>
                          <dd>{{ shoes[i].rating | ratingPoint }}</dd>
                        </div>
                      </dl>
                    </div></a
                  >
                </li>
              </ul>
            </div>
          </div>
        </div>
      </div>
    </section>
    <Footer-layout></Footer-layout>
  </body>
</template>
<script>
import HeaderLayout from "@/components/Header/HeaderLayout.vue"
import FooterLayout from "@/components/Footer/FooterLayout.vue"
import data from "@/shoe.js"

export default {
  name: "ProductPage",
  components: { HeaderLayout, FooterLayout },

  data() {
    return {
      shoes: data,
    }
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
@import "~@/assets/scss/layout/product-section";
</style>
