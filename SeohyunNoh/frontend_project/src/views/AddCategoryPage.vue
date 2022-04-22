<template>

<v-container>
    <v-row>
        <div class="col-12 text-center">
            <h3 class="pt-3"> Add Category </h3>
        </div>
    </v-row>
    <v-row>
        <div class="col-3"></div>
        <div class="col-6">
            <form>
                <div class="form-group">
                    <label>Name </label>
                    <input type="text" class="form-control" v-model="categoryName">
                </div>
                <div class="form-group">
                    <label>Description </label>
                    <textarea type="text" class="form-control" v-model="description">
                </div>
                <div class="form-group">
                    <label>Image </label>
                    <input type="text" class="form-control" v-model="imageUrl">
                </div>
                <button type="button" @click="addCategory()"> 등록하기 </v-btn>
            </form>
        </div>
    </v-row>
    
</v-container>
    
        
</template>

<script>

// import axios from 'axios'

export default {
    data() {
        return {
            categoryName: '',
            description: '',
            imageUrl: ''
        }
    },
    methods: {
        addCategory() {
            cosole.log(this.categoryName, this.description)
            
            // const newCategory = {
            //     categoryName: this.categoryName,
            //     description: this.description,
            //     imageUrl: this.imageUrl
            // }

            // axios.post('http://localhost:7777/category/create', newCategory)
            //         .then(() => {
            //             alert ("카테고리 등록 완료")
            //         })
            //         .catch((err) => {
            //             alert(err)
            //         })

        }
    }
}
</script>