<template>
  <body>
    <Header-Layout></Header-Layout>
    <product-card :productList="productList"></product-card>
    <Footer-layout></Footer-layout>
  </body>
</template>
<script>
import HeaderLayout from "@/components/Header/HeaderLayout.vue"
import FooterLayout from "@/components/Footer/FooterLayout.vue"
import ProductCard from "@/components/Product/ProductCard.vue"
import { mapState, mapActions } from "vuex"

export default {
  name: "ProductPage",

  components: { HeaderLayout, FooterLayout, ProductCard },

  computed: {
    ...mapState(["productList"]),
  },
  methods: {
    ...mapActions(["fetchProductList"]),
  },
  mounted() {
    this.fetchProductList()
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
