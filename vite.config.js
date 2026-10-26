import { defineConfig } from 'vite';
import react from '@vitejs/plugin-react';
export default defineConfig({ plugins: [react()], server: { proxy: { '/api': 'http://localhost:8081', '/swagger-ui': 'http://localhost:8081', '/v3/api-docs': 'http://localhost:8081' } } });
