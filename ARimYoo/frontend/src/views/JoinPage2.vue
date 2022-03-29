<template>
    <div>
        <v-img class="mx-auto" src ="@/assets/main/banner.png" width="370"/>
        <v-layout class="mx-auto">
            <member-register-form @submit="onSubmit"/>
        </v-layout>
    </div>
</template>

<script>
import MemberRegisterForm from '@/components/form/MemberRegisterForm.vue'
export default {
    components: { MemberRegisterForm },
    name: 'JoinPage2',
    
}
</script>

<style scoped>
.mx-auto {
     position: relative;
     margin-top:30px;
     width:50%;
}

</style>