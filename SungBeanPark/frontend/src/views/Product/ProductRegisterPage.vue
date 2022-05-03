<template>
  <div>
    <product-register @submit="onSubmit" />
  </div>
</template>

<script>
import ProductRegister from "@/components/Product/ProductRegister.vue"
import { mapState, mapActions } from "vuex"
import axios from "axios"

export default {
  name: "ProductRegisterPage",
  components: { ProductRegister },

  computed: {
    ...mapState(["productlist"]),
  },
  methods: {
    ...mapActions(["fetchProduct"]),
    onSubmit(payload) {
      const {
        productName,
        productPrice,
        gender,
        productDiscountPrice,
        discount,
        rating,
        file,
      } = payload

      let formData = new FormData()

      if (file != null) {
        formData.append("file", file)
      }
      formData.append("productName", productName)
      formData.append("productPrice", productPrice)
      formData.append("gender", gender)
      formData.append("productDiscountPrice", productDiscountPrice)
      formData.append("discount", discount)
      formData.append("rating", rating)

      axios
        .post("http://localhost:8888/product/register", formData, {
          headers: {
            "Content-Type": "multipart/form-data",
          },
        })
        .then(() => {
          alert("게시물 등록 성공!")
          this.$router.push({})
        })
        .catch(() => {
          alert("문제 발생!")
        })
    },
  },
}
</script>
