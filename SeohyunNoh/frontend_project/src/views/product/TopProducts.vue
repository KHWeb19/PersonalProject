<template>
    <div>
        <div class="container py-2">
            <div class="row">
                <div class="col-12 text-center">
                <h2 class="pt-3">Top Products</h2>
                </div>
            </div>

            <div class="row">
                <div v-for="index in this.productSize" :key="index"
                    class="col-md-6 col-xl-4 col-12 pt-3 justify-content-around d-flex">
                <product-box :product="products[index-1]" />
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import ProductBox from '@/components/product/ProductBox.vue';


export default {
  name: "TopProducts",
  components: {
      ProductBox
      },
  props: {
      products: {

      }
  },
  data() {
    return {
      productSize: 0
    }
  },
  mounted() {
    this.productSize = Math.min(8, this.products.length);
  }
}
</script>

<style scoped>

</style>
