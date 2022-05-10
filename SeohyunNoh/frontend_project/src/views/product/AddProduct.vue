<template>
    <div class="container">
        <div class="row">
            <div class="col-12 text-center">
                <h4>Add New Product</h4>
            </div>
        </div>
        <div class="row">
            <div class="col-3"></div>
            <div class="col-6">
                <form>
                    <div class="form-group">
                        <!-- 카테고리 선택 --> 
                        <label>Category</label>
                        <select class="form-control" v-model="categoryId" required>
                            <option v-for="category in categories" :key="category.id" :value="category.id">
                                {{ category.categoryName }}
                            </option>
                        </select>
                    </div>

                    <div class="form-group">
                        <label>Name</label>
                        <input type="text" v-model="name" class="form-control" >
                    </div>

                    <div class="form-group">
                        <label>Description</label>
                        <input type="text" v-model="description" class="form-control" >
                    </div>

                    <div class="form-group">
                        <label>Image Url</label>
                        <input type="text"  v-model="imageURL" class="form-control" >
                    </div>

                    <div class="form-group">
                        <label>Price</label>
                        <input type="number" v-model="price" class="form-control" >
                    </div>

                    <button type="button" class="btn btn-primary" @click="addProduct">Add Product</button>
                </form>
            </div>
            <div class="col-3"></div>
        </div>
    </div>
</template>

<script>

import axios from 'axios'

export default {
  data(){
    return {
      id : null,
      categoryId : null,
      name : null,
      description : null,
      imageURL : null,
      price : null
    }
  },
  props: {
      categories: {

      }
  },
  methods : {
    async addProduct() {
      const newProduct = {
        // id : this.id,
        categoryId : this.categoryId,
        name : this.name,
        description : this.description,
        imageURL : this.imageURL,
        price : this.price
      }
       axios.post('http://localhost:7777/product/add', newProduct)
        .then(() => {
            console.log(newProduct)
            this.$emit('fetchData')
            alert("상품이 등록되었습니다.")
            this.$router.push({path: '/product'})
        })
        .catch((err) => {
            console.log('상품 등록 에러: ' + err)
        })
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
</style>