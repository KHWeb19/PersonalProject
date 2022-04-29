<template>
    <div>
        <v-row justify="center" class="mb-1">
            <input type="text" class="mainSearch" v-model="keyword">
            <v-btn @click="goSearch" color="red darken-3" dark>
                    <v-icon>
                        mdi-magnify
                    </v-icon>
            </v-btn>
        </v-row>
    </div>
</template>

<script>
export default {
    emits: ['search'],
    name:'MainSearch',
    data () {
        return {
            keyword:''
        }
    },
    methods: {
        goSearch () {
            this.$emit('search', this.keyword)
            console.log(this.keyword)
            
        }
    }
}
</script>

<style scoped>
.mainSearch{
    border-radius:5px;
    position: relative;
    width:400px;
    height:38px;
    background-color: rgb(240, 238, 238);
    outline-color: rgb(204, 32, 32);
    padding-left:10px;
    font-family: 'Noto Sans KR', sans-serif;
    float:left;
}
</style>