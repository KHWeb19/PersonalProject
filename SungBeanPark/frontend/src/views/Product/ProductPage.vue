<template>
  <body>
    <Header-Layout></Header-Layout>
    <product-card
      :productList="productList"
      :list-array="pageArray"
    ></product-card>
    <Footer-layout></Footer-layout>
  </body>
</template>
<script>
import HeaderLayout from "@/components/Header/HeaderLayout.vue"
import FooterLayout from "@/components/Footer/FooterLayout.vue"
import ProductCard from "@/components/Product/ProductCard.vue"
import { mapState, mapActions } from "vuex"
import axios from "axios"
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
  data() {
    return {
      pageArray: [],
    }
  },
  created() {
    axios
      .get("http://localhost:8888/product/list")
      .then((res) => {
        this.pageArray = res.data
      })
      .catch((err) => {
        console.log(err)
      })
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
<style scoped></style>
