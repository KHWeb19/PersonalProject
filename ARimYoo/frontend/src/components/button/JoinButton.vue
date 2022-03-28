<template>
    <div>
      <router-link to="/join">
        <v-btn
            color="white"
            height="25"
            v-bind="attrs"
            v-on="on"
        >
            Join
          </v-btn>
      </router-link>
    </div>
</template>

<script>
export default {
    name: 'JoinButton',

}
</script>