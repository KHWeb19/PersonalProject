<template>
  <div class="container">
    <div class="row">
      <div class="col-12 text-center">
        <h4 class="pt-3">Our Categories</h4>
        <router-link id="add-category" :to="{name : 'AddCategory'}">
          <button class="btn">Add a new Category</button>
        </router-link>
      </div>
    </div>
    <div class="row">
        <!-- <category-box :category="category" v-for="category in categories" :key="category.id" /> -->
      <div v-for="category in categories" :key="category.id" class="col-md-6 col-xl-4 col-12 pt-3  justify-content-around d-flex">
        <category-box :category="category" />
      </div>
    </div>
  </div>
</template>

<script>

import CategoryBox from '../../components/category/CategoryBox.vue';

export default {
  name: 'Category',
  components: {
    CategoryBox
    },
  props: {
      categories: {

      }
  }
}
</script>

<style scoped>
h4 {
  font-family: 'Roboto', sans-serif;
  color: #484848;
  font-weight: 700;
}
#add-category {
  float: right;
  font-weight: 500;
}
</style>