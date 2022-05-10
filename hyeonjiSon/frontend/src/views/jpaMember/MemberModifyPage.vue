<template>
<div>
   <h1> Modify Page </h1>
   
   <modify-form @submit="onSubmit"/>
</div>
</template>

<script>
import ModifyForm from '@/components/jpaMember/ModifyForm.vue'

export default {
    name: 'memberModifyPage' ,
    components: {
       ModifyForm
    }
}
</script>