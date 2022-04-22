 <template>
   <div class="container">
     <div class="row">
       <div class="col-12 text-center">
         <h4 class="pt-3">Add new Category</h4>
       </div>
     </div>

     <div class="row">
       <div class="col-3"></div>
       <div class="col-md-6 px-5 px-md-0">
        <form>
          <div class="form-group">
            <label>Category Name</label>
            <input type="text" class="form-control" v-model="categoryName" required>
          </div>
          <div class="form-group">
            <label>Description</label>
            <input type="text" class="form-control" v-model="description" required>
          </div>
          <div class="form-group">
            <label>ImageURL</label>
            <input type="url" class="form-control" v-model="imageURL" required>
          </div>
          <button type="button" class="btn btn-primary" @click="addCategory">Submit</button>
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
      categoryName : null,
      description : null,
      imageURL : null,
    }
  },
  props: {
      categories: {

      }
  },
  methods : {
    async addCategory() {
      const newCategory = {
        categoryName : this.categoryName,
        description : this.description,
        imageUrl : this.imageURL,
      }

        axios.post('http://localhost:7777/category/create', newCategory)
        .then(() => {
            this.$emit('fetchData')
            alert("카테고리가 등록되었습니다.")
            this.$router.push({path: '/category'})
        })
        .catch((err) => {
            console.log('카테고리 등록 에러: ' + err)
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
