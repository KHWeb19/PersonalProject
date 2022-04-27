<template>
    <h2>{{user}}</h2>
</template>

<script>
import {mapActions, mapState} from 'vuex'

export default{
    computed:{
        ...mapState(['user'])
    },

    methods:{
        ...mapActions(['get_user'])
    },

    mounted(){
        this.get_user()
    }
}
</script>
