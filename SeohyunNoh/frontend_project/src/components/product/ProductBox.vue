<template>
  <div class="card h-100 w-100">
    <div class="embed-responsive embed-responsive-16by9">
      <router-link :to="{ name: 'ShowDetails', params: { id: product.id } }">
      <img class="card-img-top embed-responsive-item" :src="product.imageURL" alt="Product Image"/>
      </router-link>
    </div>
    <div class="card-body">
      <router-link :to="{ name: 'ShowDetails', params: { id: product.id } }">
      <p class="card-text font-italic">{{ product.description }}</p>
      <hr>
      <h5 class="card-title">{{ product.name }}</h5>
      <p class="card-text"><sup>₩</sup>{{ product.price }}</p>
      </router-link>
        
      <router-link :to="{ name: 'EditProduct', params: { id: product.id } }" v-show="$route.name == 'Product'">
          <button class="btn btn-primary">Edit</button>   
      </router-link> 
        
      <button class="btn btn-primary" v-show="$route.name == 'Product'" @click="deleteProduct">Delete</button>     
    </div>
  </div>
</template>

<script>

import axios from 'axios'

export default {
  name: 'ProductBox',
  props: {
      product: {

      }
    },
  methods: {
    showDetails() {
      this.$router.push({
        name: 'ShowDetails',
        params: { id: this.product.id },
      })
    },
    deleteProduct() {
            axios.delete(`http://localhost:7777/product/${this.product.id}`)
                    .then(() => {
                        alert('삭제 성공!')
                        this.$router.push({ name: 'Product' })
                    })
                    .catch(() => {
                        alert('삭제 실패! 문제 발생!')
                    })
    }
  },
}
</script>

<style scoped>
.embed-responsive .card-img-top {
  object-fit: cover;
}
a {
  text-decoration: none;
}
.card-title {
  color: #484848;
  font-size: 1.1rem;
  font-weight: 400;
}
.card-title:hover {
  font-weight: bold;
}
.card-text {
  font-size: 0.9rem;
}
#edit-product {
  float: right;
}
</style>