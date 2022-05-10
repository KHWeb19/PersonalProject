<template>
    <v-container v-if="posts.content.length">
        <v-row justify="center">
            <button class="pagination-button mx-2" v-if="startPage>this.posts.pageable.pageSize-1" @click="previousBtn">Previous</button>
            <button class="pagination-button" v-for="n in loopCount" :key="n" @click="newRequest(n)" 
            :style="currentCheck(n) ? {'color': 'red'} : null">
                {{n+startPage}}
            </button>
            <button class="pagination-button mx-2" v-if="startPage+posts.pageable.pageSize < this.posts.totalPages" @click="nextBtn">Next</button>
        </v-row>
    </v-container>
</template>

<script>
export default {
    
    props:{
        posts: Object
    },
    computed:{
        startPage: function() {
            return Math.floor(this.posts.pageable.pageNumber / this.posts.pageable.pageSize) * this.posts.pageable.pageSize
        },
        endPage: function(){
            return Math.min(this.startPage + this.posts.pageable.pageSize - 1, this.posts.totalPages)
        },
        loopCount: function(){
            return this.posts.totalPages-1 <= this.endPage ? this.posts.totalPages-this.startPage : this.posts.pageable.pageSize
        }
    },
    methods:{
        newRequest(n){
            this.$router.push({query: {page: n+this.startPage, size: this.posts.pageable.pageSize}})
        },
        previousBtn(){
            this.$router.push({query: {page: this.startPage+1 - this.posts.pageable.pageSize, size: this.posts.pageable.pageSize}})
        },
        nextBtn(){
            this.$router.push({query: {page: this.startPage+1 + this.posts.pageable.pageSize, size: this.posts.pageable.pageSize}})
        },
        currentCheck(n){
            return n+this.startPage-1===this.posts.pageable.pageNumber ? true : false 
        }
    }
  }
</script>

<style scoped>
    .pagination-button {
        font-size: 1em;
        padding: 8px;
        margin: 2px;
        font-weight: bold;
    }

    .pagination-button:hover{
        
        cursor: pointer;
    }

    .currentpage{
        background-color: blue;
        color: white;
        font-size: 1em;
        padding: 8px;
        margin: 2px;
        font-weight: bold;
    }
</style>
