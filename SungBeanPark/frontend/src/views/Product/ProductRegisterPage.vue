<template>
  <div>
    <product-register @submit="OnSubmit" />
  </div>
</template>

<script>
import ProductRegister from "@/components/Product/ProductRegister.vue"
import axios from "axios"

export default {
  name: "ProductRegisterPage",
  components: { ProductRegister },
  methods: {
    OnSubmit(payload) {
      const {
        productName,
        productPrice,
        gender,
        productDiscountPrice,
        discount,
        rating,
      } = payload
      axios
        .post("http://localhost:8888/product/register", {
          productName,
          productPrice,
          gender,
          productDiscountPrice,
          discount,
          rating,
        })
        .then(() => {
          alert("상품등록완료")
          this.$router.push({
            name: "ProductPage",
          })
        })
        .catch(() => {
          alert("등록실패!")
        })
    },
  },
}
</script>
