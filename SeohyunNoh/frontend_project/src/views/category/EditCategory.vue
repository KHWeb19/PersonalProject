<template>
    <div class="container">
        <div class="row">
            <div class="col-12 text-center">
                <h4 class="pt-3"> Edit Category</h4>
            </div>
        </div>
        <div class="row">
            <div class="col-3"></div>
            <div class="col-6">
                <form v-if="category">
                    <div class="form-group">
                        <label>Category Name</label>
                        <input type="text" class="form-control"
                               v-model="category.categoryName"  required/>
                    </div>
                    <div class="form-group">
                        <label>Description</label>
                        <input type="text" class="form-control"
                               v-model="category.description"  required/>
                    </div>
                    <div class="form-group">
                        <label>Image URL</label>
                        <input type="text" class="form-control"
                               v-model="category.imageUrl"  required/>
                    </div>
                    <button type="button" class="btn btn-primary" @click="editCategory" >Submit</button>
                </form>
            </div>
            <div class="col-3"></div>
        </div>
    </div>
</template>
<script>
import axios from 'axios'

export default {
    data() {
        return {
            category: null,
            id: null
        }
    },
    props: {
        categories: {

        }
    },
    methods: {
        async editCategory() {
            delete this.category['products']

            console.log(this.category)

             axios.post(`http://localhost:7777/category/update/${this.id}`, this.category)
                .then(() => {
                        this.$emit("fetchData")
                        alert("카테고리가 수정되었습니다.")
                        this.$router.push({path: '/category'})
                    })
                .catch((err) => {
                        console.log('카테고리 수정 에러: ' + err)
                })
            }
        },
        mounted() {
            this.id = this.$route.params.id;
            this.category = this.categories.find(category => category.id == this.id)
        }
    }
</script>