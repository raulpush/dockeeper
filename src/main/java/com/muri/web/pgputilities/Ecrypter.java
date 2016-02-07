package com.muri.web.pgputilities;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class Ecrypter {

    private static final String PASSPHRASE = "Password";

    private static final String DE_INPUT = "h:/sec/cypher-text.dat";
    private static final String DE_OUTPUT = "h:/sec/plain-text.txt";
    private static final String DE_KEY_FILE = "h:/sec/private_key_sender.asc";
    // private static final String DE_KEY_FILE = "h:/sec/private_key_sender_bun.asc";

    private static final String E_INPUT = "h:/sec/plain-text.txt";
    private static final String E_OUTPUT = "h:/sec/cypher-text.dat";
    private static final String E_KEY_FILE = "h:/sec/public_key_sender.asc";

    // private static final String E_KEY_FILE = "h:/sec/public_key_sender_bun.asc";

    // public static void main(String[] s)
    // {
    // InputStream pubIn =null;
    // InputStream priIn = null;
    // try {
    // // RSAKeyPairUtilGenerator rkpg = new RSAKeyPairUtilGenerator();
    // // Security.addProvider(new BouncyCastleProvider());
    // // KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA", "BC");
    // // kpg.initialize(1024);
    // // KeyPair kp = kpg.generateKeyPair();
    // // FileOutputStream out1 = new FileOutputStream(DE_KEY_FILE);
    // // FileOutputStream out2 = new FileOutputStream(E_KEY_FILE);
    // // rkpg.exportKeyPair(out1, out2, kp.getPublic(), kp.getPrivate(), "raulpush@yahoo.commm",
    // "Password".toCharArray(), true);
    // //
    // // out1.close();
    // // out2.close();
    // // testEncrypt();
    // // testDecrypt();
    // pubIn = new FileInputStream(E_KEY_FILE);
    // priIn = new FileInputStream(DE_KEY_FILE);
    // // Pair<String, String> pp = PGPKeysGenerator.generateKeys("test@email.ro", PASSPHRASE);
    // // pubIn = new ByteArrayInputStream(pp.getFirst().getBytes());
    // // priIn = new ByteArrayInputStream(pp.getSecond().getBytes());
    //
    // //FileInputStream in = new FileInputStream(DE_INPUT);
    // //FileOutputStream out2 = new FileOutputStream(DE_OUTPUT);
    // //FileOutputStream out1 = new FileOutputStream(E_OUTPUT);
    //
    // ByteArrayOutputStream out12 = new ByteArrayOutputStream();
    // ByteArrayOutputStream text = new ByteArrayOutputStream();
    // text.write("test".getBytes());
    // text.close();
    //
    // testEncrypt(pubIn, out12,text);
    // String resp = new String(Base64.encode(out12.toByteArray()));
    // System.out.println(resp);
    // ByteArrayInputStream in = new ByteArrayInputStream(Base64.decode(resp.getBytes()));
    // testDecrypt(in, priIn, out12);
    //
    //
    // } catch (Exception e) {
    // e.printStackTrace();
    // }finally {
    //
    // try {
    // pubIn.close();
    // priIn.close();
    // } catch (IOException e) {
    // e.printStackTrace();
    // }
    // }
    // }

    public static void testDecrypt() throws Exception {
	PGPFileProcessor p = new PGPFileProcessor();
	p.setInputFileName(DE_INPUT);
	p.setOutputFileName(DE_OUTPUT);
	p.setPassphrase(PASSPHRASE);
	p.setSecretKeyFileName(DE_KEY_FILE);
	System.out.println(p.decrypt());
    }

    public static void testEncrypt() throws Exception {
	PGPFileProcessor p = new PGPFileProcessor();
	p.setInputFileName(E_INPUT);
	p.setOutputFileName(E_OUTPUT);
	p.setPassphrase(PASSPHRASE);
	p.setPublicKeyFileName(E_KEY_FILE);
	System.out.println(p.encrypt());
    }

    public static void testDecrypt(InputStream in, InputStream keyIn, OutputStream out) throws Exception {
	PGPFileProcessor p = new PGPFileProcessor();
	p.setPassphrase(PASSPHRASE);
	System.out.println(p.decrypt(in, keyIn, out));
    }

    public static void testEncrypt(InputStream keyIn, OutputStream out, ByteArrayOutputStream text) throws Exception {
	PGPFileProcessor p = new PGPFileProcessor();
	System.out.println(p.encrypt(keyIn, out, text));
    }
}
