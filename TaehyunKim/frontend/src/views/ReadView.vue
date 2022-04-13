<template>
    <read-members-component :users="users"></read-members-component>
</template>

<script>
import {mapState, mapActions} from "vuex"
import ReadMembersComponent from "../components/ReadMembersComponent.vue"

export default{
    components:{
        ReadMembersComponent
    },

    computed:{
        ...mapState(['users'])
    },

    methods: {
        ...mapActions(['read_users'])
    },

    mounted(){
        this.read_users();
    }
}
</script>
